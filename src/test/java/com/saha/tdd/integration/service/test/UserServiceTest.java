package com.saha.tdd.integration.service.test;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.saha.tdd.crm.dao.UserDao;
import com.saha.tdd.crm.entity.User;
import com.saha.tdd.crm.service.UserService;

@RunWith(Arquillian.class)
public class UserServiceTest  {

	
	@Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(User.class.getPackage())
                .addPackage(UserDao.class.getPackage())
                .addPackage(UserService.class.getPackage())
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("test-ds.xml");
    }
		
		@Inject UserService userService;
		
		@Test
		public void sample(){
			User user = new User();
			user.setName("Melih");
			user.setLastname("Sakarya");
			user.setAge(35);
			userService.save(user);
			Assert.assertNotNull(user.getId());
		}
		

}
