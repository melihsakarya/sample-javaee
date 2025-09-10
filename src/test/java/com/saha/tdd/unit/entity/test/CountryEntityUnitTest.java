package com.saha.tdd.unit.entity.test;

import org.junit.Assert;
import org.junit.Test;

import com.saha.tdd.crm.entity.Country;

public class CountryEntityUnitTest {

	@Test
	public void createCountryTest(){
		Country country = new Country();
		country.setName("Turkey");
		
		Assert.assertEquals("Turkey", country.getName());
	}

	@Test
	public void countryNullNameTest(){
		Country country = new Country();
		
		Assert.assertNull(country.getName());
	}

	@Test
	public void countryEmptyNameTest(){
		Country country = new Country();
		country.setName("");
		
		Assert.assertEquals("", country.getName());
	}

	@Test
	public void countryBaseEntityPropertiesTest(){
		Country country = new Country();
		Long testId = 10L;
		
		country.setId(testId);
		
		Assert.assertEquals(testId, country.getId());
	}
}