package com.saha.tdd.crm.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.saha.tdd.crm.dao.CountryDao;
import com.saha.tdd.crm.entity.Country;

@Stateless
public class CountryService implements Serializable{

	
	@Inject CountryDao countryDao;
	
	public void save(Country country){
		if(country.getName() == null)
			return;
		countryDao.save(country);
	}
	
	
	
	
}
