package com.saha.tdd.crm.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;

@Entity
public class Country extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
