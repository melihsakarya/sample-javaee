package com.saha.tdd.crm.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.saha.tdd.crm.entity.Country;

@Stateless
public class CountryService implements Serializable{

	@PersistenceContext EntityManager em;
	
	
	public void save(Country country){
		if(country.getName() == null)
			return;
		em.persist(country);
	}
	
	
	
	
}
