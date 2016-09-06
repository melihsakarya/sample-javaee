package com.saha.tdd.crm.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;

@Entity
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String lastname;
	private Integer age;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
