package com.hibernate.jpa.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hibernate.jpa.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", 
					new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	//Custom Row Mapper in case if the database column doesnt match with field in the person class
	//To use instead of new BeanPropertyRowMapper<Person>(Person.class)) in retrieve usages
	static class PersonRowMapper implements RowMapper<Person>{
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			return person;
		}
		
	}
	
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id},
					new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id = ?", new Object[]{id});
	}
	
	public int insertValues(Person person) {
		return jdbcTemplate.update("insert into person (id , name , location )\r\n"
				+ "values( ?, ?, ?)", 
				new Object[]{person.getId(), person.getName(), person.getLocation()});
	}
	
	public int updateValues(Person person) {
		return jdbcTemplate.update("update person set name = ? , location = ? \r\n"
				+ "where id = ?", 
				new Object[]{person.getName(), person.getLocation(), person.getId()});
	}
}
