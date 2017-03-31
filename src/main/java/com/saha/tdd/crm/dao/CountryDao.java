package com.saha.tdd.crm.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.saha.tdd.crm.entity.Country;

@Stateless
public class CountryDao {

	@PersistenceContext EntityManager em;
	
	public void save(Country country){
	
		em.persist(country);
	}
}
