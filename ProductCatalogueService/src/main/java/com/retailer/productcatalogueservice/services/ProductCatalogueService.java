package com.retailer.productcatalogueservice.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.retailer.productcatalogueservice.ProductCatalogue;
import com.retailer.productcatalogueservice.ProductItem;

@Path("/productcatalogue")
public class ProductCatalogueService {

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProductService(ProductItem item) throws Exception {
		ProductCatalogue catalogue = new ProductCatalogue();
		catalogue.addProduct(item);
	}

	@POST
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeProductService(ProductItem item) throws ClassNotFoundException, SQLException, IOException {
		ProductCatalogue catalogue = new ProductCatalogue();
		catalogue.removeProductFromCatalogue(item);
	}

	@POST
	@Path("/fetchByType}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<ProductItem> fetchProductsForAType(String type) throws ClassNotFoundException, SQLException, IOException {
		ProductCatalogue catalogue = new ProductCatalogue();
		return catalogue.getProductListBasedOnType(type);
	}

	@GET
	@Path("/fetchAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductItem> fetchAllProductsFormCatalogue() throws ClassNotFoundException, SQLException, IOException {
		ProductCatalogue catalogue = new ProductCatalogue();
		return catalogue.getAllProductsFromCatalogue();
	}
	
}
