package com.saha.tdd.crm.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.saha.tdd.crm.dao.GenericDao;
import com.saha.tdd.crm.dao.ProductDao;
import com.saha.tdd.crm.entity.Product;

@Stateless
public class ProductService extends GenericService<Product>{

	@Inject ProductDao productDao;
	
	
	@Override
	public GenericDao<Product> getDao() {
		return productDao;
	}

	
	public Product find(Long id){
		return getDao().getEntityManager().find(Product.class, id);
	}
}
