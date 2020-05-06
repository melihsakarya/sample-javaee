package com.saha.tdd.unit.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.saha.tdd.crm.dao.UserDao;
import com.saha.tdd.crm.entity.User;
import com.saha.tdd.crm.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest {

	
	@InjectMocks UserService userService;
	@Mock UserDao userDao;
	
	@Test
	public void saveUserTest(){
		User user = new User();
		user.setName("Melih");
		user.setLastname("Sakarya");
		user.setAge(35);
		Assert.assertTrue(!userService.save(user));
	}
	
	@Test
	public void saveUserNameControlTest(){
		User user = new User();
		user.setLastname("Sakarya");
		user.setAge(35);
		Assert.assertFalse(userService.save(user));
	}
}

