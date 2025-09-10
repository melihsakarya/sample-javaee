package com.saha.tdd.unit.service.test;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.saha.tdd.crm.dao.CountryDao;
import com.saha.tdd.crm.entity.Country;
import com.saha.tdd.crm.service.CountryService;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceUnitTest {

	@InjectMocks 
	CountryService countryService;
	
	@Mock 
	CountryDao countryDao;

	@Test
	public void saveCountryTest(){
		Country country = new Country();
		country.setName("Turkey");
		
		countryService.save(country);
		
		verify(countryDao, times(1)).save(country);
	}

	@Test
	public void saveCountryWithNullNameTest(){
		Country country = new Country();
		country.setName(null);
		
		countryService.save(country);
		
		// Should not call dao.save when name is null
		verify(countryDao, never()).save(country);
	}

	@Test
	public void saveCountryWithEmptyNameTest(){
		Country country = new Country();
		country.setName("");
		
		countryService.save(country);
		
		// Should call dao.save when name is empty string (not null)
		verify(countryDao, times(1)).save(country);
	}
}