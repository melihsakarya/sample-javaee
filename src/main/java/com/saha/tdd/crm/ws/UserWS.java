package com.saha.tdd.crm.ws;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.saha.tdd.crm.entity.User;
import com.saha.tdd.crm.service.UserService;

@WebService
public class UserWS {

	@Inject UserService userService;
	
	@WebMethod
	public void kaydet(String name, String lastname){
		User user = new User();
		user.setName(name);
		user.setLastname(lastname);
	
		userService.save(user);
	}
	 
}
 
