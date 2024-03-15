package com.example.demo.inheritance.entity.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.inheritance.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class EmployeeRepository {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	
	public List<Employee> retrieveAllEmployees() {
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}

}
