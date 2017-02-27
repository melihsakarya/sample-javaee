package com.saha.tdd.crm.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.saha.tdd.crm.entity.User;
import com.saha.tdd.crm.service.UserService;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
public class UserRS {

	
	@Inject UserService userService;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {

		userService.save(user);

		return Response.status(201).entity(user).build();
 
	}
	
	@GET
	@Path("/remove/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean remove(@PathParam("id") Long id) {

		User user = userService.find(id);
		return userService.remove(user);

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") Long id) {
		return userService.find(id);
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> list() {
		return userService.list();
	}

}
