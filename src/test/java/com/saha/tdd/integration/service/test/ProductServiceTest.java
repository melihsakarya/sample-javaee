package com.saha.tdd.integration.service.test;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.saha.tdd.crm.dao.UserDao;
import com.saha.tdd.crm.entity.Product;
import com.saha.tdd.crm.entity.User;
import com.saha.tdd.crm.service.ProductService;
import com.saha.tdd.crm.service.UserService;

@RunWith(Arquillian.class)
public class ProductServiceTest {


	
	@Inject ProductService productService;
	
	@Test
	public void productSaveTest(){
		Product product = new Product();
		product.setName("IPhone");
		
		productService.save(product);
		Assert.assertNotNull(product);
	}
}















