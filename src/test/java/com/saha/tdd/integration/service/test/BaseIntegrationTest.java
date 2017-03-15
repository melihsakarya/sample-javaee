package com.saha.tdd.integration.service.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.saha.tdd.crm.dao.UserDao;
import com.saha.tdd.crm.entity.User;
import com.saha.tdd.crm.service.UserService;

public class BaseIntegrationTest {

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
}
 