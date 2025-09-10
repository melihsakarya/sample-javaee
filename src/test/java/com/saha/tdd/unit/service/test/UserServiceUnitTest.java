package com.saha.tdd.unit.service.test;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;

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

	@InjectMocks 
	UserService userService;
	
	@Mock 
	UserDao userDao;

	@Mock
	EntityManager entityManager;
	
	@Test
	public void saveUserTest(){
		User user = new User();
		user.setName("Melih");
		user.setLastname("Sakarya");
		user.setAge(35);
		Assert.assertTrue(userService.save(user));
		verify(userDao, times(1)).save(user);
	}
	
	@Test
	public void saveUserNameControlTest(){
		User user = new User();
		user.setLastname("Sakarya");
		user.setAge(35);
		Assert.assertFalse(userService.save(user));
		verify(userDao, never()).save(user);
	}

	@Test
	public void findUserTest(){
		Long userId = 1L;
		User expectedUser = new User();
		expectedUser.setId(userId);
		expectedUser.setName("Test User");
		
		when(userDao.getEntityManager()).thenReturn(entityManager);
		when(entityManager.find(User.class, userId)).thenReturn(expectedUser);
		
		User result = userService.find(userId);
		Assert.assertEquals(expectedUser, result);
		Assert.assertEquals("Test User", result.getName());
	}

	@Test
	public void updateUserTest(){
		User user = new User();
		user.setName("Updated User");
		user.setLastname("Updated Lastname");
		user.setAge(30);
		Assert.assertTrue(userService.update(user));
		verify(userDao, times(1)).update(user);
	}

	@Test
	public void removeUserTest(){
		User user = new User();
		user.setName("User to Remove");
		Assert.assertTrue(userService.remove(user));
		verify(userDao, times(1)).remove(user);
	}
}

