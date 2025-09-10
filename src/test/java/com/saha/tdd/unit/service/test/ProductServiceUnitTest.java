package com.saha.tdd.unit.service.test;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.saha.tdd.crm.dao.ProductDao;
import com.saha.tdd.crm.entity.Product;
import com.saha.tdd.crm.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceUnitTest {

	@InjectMocks 
	ProductService productService;
	
	@Mock 
	ProductDao productDao;

	@Mock
	EntityManager entityManager;

	@Test
	public void saveProductTest(){
		Product product = new Product();
		product.setName("Test Product");
		Assert.assertTrue(productService.save(product));
		verify(productDao, times(1)).save(product);
	}

	@Test
	public void findProductTest(){
		Long productId = 1L;
		Product expectedProduct = new Product();
		expectedProduct.setId(productId);
		expectedProduct.setName("Test Product");
		
		when(productDao.getEntityManager()).thenReturn(entityManager);
		when(entityManager.find(Product.class, productId)).thenReturn(expectedProduct);
		
		Product result = productService.find(productId);
		Assert.assertEquals(expectedProduct, result);
		Assert.assertEquals("Test Product", result.getName());
	}

	@Test
	public void updateProductTest(){
		Product product = new Product();
		product.setName("Updated Product");
		Assert.assertTrue(productService.update(product));
		verify(productDao, times(1)).update(product);
	}

	@Test
	public void removeProductTest(){
		Product product = new Product();
		product.setName("Product to Remove");
		Assert.assertTrue(productService.remove(product));
		verify(productDao, times(1)).remove(product);
	}
}