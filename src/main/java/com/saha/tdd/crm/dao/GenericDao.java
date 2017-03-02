package com.saha.tdd.crm.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	EntityManager entityManager;

	public void save(E obj) {
		entityManager.persist(obj);
	}

	public void remove(E obj) {
		obj = entityManager.merge(obj);
		entityManager.remove(obj);
	}

	public void update(E obj) {
		entityManager.merge(obj);
	}

	@SuppressWarnings("unchecked")
	public List<E> list() {
		return entityManager.createQuery(getQuery()).getResultList();
	}

	public abstract String getQuery();
	
	public void refresh(E obj){
		entityManager.refresh(obj);
	}
	
	
	public EntityManager getEntityManager(){
		return this.entityManager;
	}
}













