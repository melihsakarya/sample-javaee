package com.saha.tdd.unit.entity.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.saha.tdd.crm.entity.User;

public class UserEntityUnitTest {

	@Test
	public void createUserTest(){
		User user = new User();
		user.setName("John");
		user.setLastname("Doe");
		user.setAge(30);
		
		Assert.assertEquals("John", user.getName());
		Assert.assertEquals("Doe", user.getLastname());
		Assert.assertEquals(Integer.valueOf(30), user.getAge());
	}

	@Test
	public void userBaseEntityPropertiesTest(){
		User user = new User();
		Long testId = 1L;
		Date testDate = new Date();
		String testUser = "testuser";
		
		user.setId(testId);
		user.setCreateUser(testUser);
		user.setUpdateUser(testUser);
		user.setCreateDate(testDate);
		user.setUpdateDate(testDate);
		
		Assert.assertEquals(testId, user.getId());
		Assert.assertEquals(testUser, user.getCreateUser());
		Assert.assertEquals(testUser, user.getUpdateUser());
		Assert.assertEquals(testDate, user.getCreateDate());
		Assert.assertEquals(testDate, user.getUpdateDate());
	}

	@Test
	public void userNullValuesTest(){
		User user = new User();
		
		Assert.assertNull(user.getName());
		Assert.assertNull(user.getLastname());
		Assert.assertNull(user.getAge());
		Assert.assertNull(user.getId());
	}
}