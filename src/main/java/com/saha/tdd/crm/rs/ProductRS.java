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

import com.saha.tdd.crm.entity.Product;
import com.saha.tdd.crm.service.ProductService;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
public class ProductRS {

	@Inject
	ProductService productService;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Product product) {

		productService.save(product);

		return Response.status(201).entity(product).build();

	}

	@GET
	@Path("/remove/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean remove(@PathParam("id") Long id) {

		Product urun = productService.find(id);
		return productService.remove(urun);

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductById(@PathParam("id") Long id) {
		return productService.find(id);
	}


	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> list() {
		return productService.list();
	}
}
