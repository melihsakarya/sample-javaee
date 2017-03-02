package com.saha.tdd.crm.dao;

import javax.ejb.Stateless;

import com.saha.tdd.crm.entity.Category;

@Stateless
public class CategoryDao extends GenericDao<Category>{

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return "from Category";
	}

}
