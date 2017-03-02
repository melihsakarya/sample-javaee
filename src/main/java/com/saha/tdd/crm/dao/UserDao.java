package com.saha.tdd.crm.dao;

import java.io.Serializable;

import javax.ejb.Stateful;

import com.saha.tdd.crm.entity.User;

@Stateful
public class UserDao extends GenericDao<User> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String getQuery() {
		return "from User";
	}

}
