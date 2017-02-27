package com.saha.tdd.crm.rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.saha.tdd.crm.entity.Urun;
import com.saha.tdd.crm.service.UrunService;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
public class ProductRS {

	@Inject
	UrunService productService;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Urun urun) {

		productService.save(urun);

		return Response.status(201).entity(urun).build();

	}

	@GET
	@Path("/remove/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean remove(@PathParam("id") Long id) {

		Urun urun = productService.find(id);
		return productService.remove(urun);

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Urun getProductById(@PathParam("id") Long id) {
		return productService.find(id);
	}


}
