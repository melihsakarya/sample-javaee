package com.saha.tdd.unit.entity.test;

import org.junit.Assert;
import org.junit.Test;

import com.saha.tdd.crm.entity.Product;

public class ProductEntityUnitTest {

	@Test
	public void createProductTest(){
		Product product = new Product();
		product.setName("Test Product");
		
		Assert.assertEquals("Test Product", product.getName());
	}

	@Test
	public void productNullNameTest(){
		Product product = new Product();
		
		Assert.assertNull(product.getName());
	}

	@Test
	public void productEmptyNameTest(){
		Product product = new Product();
		product.setName("");
		
		Assert.assertEquals("", product.getName());
	}

	@Test
	public void productBaseEntityPropertiesTest(){
		Product product = new Product();
		Long testId = 5L;
		
		product.setId(testId);
		
		Assert.assertEquals(testId, product.getId());
	}
}