package com.saha.tdd.crm.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.saha.tdd.crm.dao.GenericDao;
import com.saha.tdd.crm.dao.UrunDao;
import com.saha.tdd.crm.entity.Urun;

@Stateless
public class UrunService extends GenericService<Urun>{

	@Inject UrunDao urunDao;
	
	@Override
	public GenericDao<Urun> getDao() {
		return urunDao;
	}

}
