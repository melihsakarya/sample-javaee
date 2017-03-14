package com.saha.tdd.crm.service;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.saha.tdd.crm.dao.GenericDao;
import com.saha.tdd.crm.dao.UserDao;
import com.saha.tdd.crm.entity.User;

@Stateful
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserService extends GenericService<User> implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject UserDao userDao;
	
	@Override
	public GenericDao<User> getDao() {
		return userDao;
	}

	
	public User find(Long id){
		return getDao().getEntityManager().find(User.class, id);
	}
	
	
	@Override
	public boolean save(User obj) {
		if(obj.getName() == null)
			return false;
		return super.save(obj);
	}
	

	int topla(int x, int y){
		return x + y;
	}
	
	
	
	
	
	
	
	
	
	
	
}




