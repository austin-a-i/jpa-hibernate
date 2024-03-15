package com.example.demo.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.entity.Audience;
import com.example.demo.data.entity.Genre;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class AudienceRepository {
	
	@Autowired
	EntityManager entityManager;
	
	public Audience findById(long id) {
		return entityManager.find(Audience.class, id);
	}
	
	public Audience saveAudience(Audience audience) {
		if (audience.getId() == null) {
			entityManager.persist(audience);
		} else {
			entityManager.merge(audience);
		}
		return audience;
	}
	
	public void deleteById(long id) {
		Audience audience = findById(id);
		entityManager.remove(audience);
	}
	
	/*
	 * All changes done are updated irrespective of the save method due to the @Transaction annotation
	 * because it will be viewed as one transaction
	 */
	public void saveAudienceWithGenre() {
		Genre genre = new Genre("Country");
		entityManager.persist(genre);
		
		Audience audience = new Audience("Cow Boy");
		audience.setGenre(genre);
		entityManager.persist(audience);

	}

}
