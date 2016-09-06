package com.saha.tdd.crm.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.saha.tdd.crm.dao.GenericDao;


public abstract class GenericService<E> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public abstract GenericDao<E> getDao();

//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean save(E obj){
		getDao().save(obj);
		return true;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean remove(E obj){
		getDao().remove(obj);
		return true;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean update(E obj){
		getDao().update(obj);
		return true;
	}

	public List<E> list() {
		return getDao().list();
	}
}
