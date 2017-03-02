package com.saha.tdd.crm.dao;

import javax.ejb.Stateless;

import com.saha.tdd.crm.entity.Urun;

@Stateless
public class UrunDao extends GenericDao<Urun>{

	@Override
	public String getSorgu() {
		// TODO Auto-generated method stub
		return "from Urun";
	}

}
