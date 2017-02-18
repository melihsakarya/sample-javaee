package com.saha.tdd.crm.rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.saha.tdd.crm.entity.User;
import com.saha.tdd.crm.service.UserService;

@Path("/user")
public class UserRS {

	
	@Inject UserService userService;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {

		userService.save(user);

		return Response.status(201).entity(user).build();

	}
	
}
