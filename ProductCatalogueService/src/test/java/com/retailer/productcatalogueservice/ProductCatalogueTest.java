package com.retailer.productcatalogueservice;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

import com.retailer.productcatalogueservice.ProductCatalogue;
import com.retailer.productcatalogueservice.ProductItem;

public class ProductCatalogueTest {

	@Test
	public void addProduct_fetchSizeAs_2() throws ClassNotFoundException, SQLException, IOException {
		System.setProperty("cfg.file", "C:\\ProductCatalogueAndPricing\\ProductCatalogueService\\src\\webapp\\resources\\external\\cfg.properties");
		
		ProductCatalogue catalogue = new ProductCatalogue();
		
		ProductItem item = new ProductItem();
		item.setDesc("Queensize");
		item.setType("furniture");
		item.setName("bed");

		ProductItem item1 = new ProductItem();
		item.setDesc("Kingsize");
		item.setType("furniture");
		item.setName("bed");

		catalogue.addProduct(item);
		catalogue.addProduct(item1);

		Assert.assertEquals(catalogue.getAllProductsFromCatalogue().size(), 2);
	}

	@Test
	public void addProduct_fetchSizeForType_1() throws ClassNotFoundException, SQLException, IOException {
		System.setProperty("cfg.file", "C:\\ProductCatalogueAndPricing\\ProductCatalogueService\\src\\webapp\\resources\\external\\cfg.properties");
		
		ProductCatalogue catalogue = new ProductCatalogue();
		
		ProductItem item = new ProductItem();
		item.setDesc("forbelow5yrs");
		item.setType("toys");
		item.setName("scalemodelcar");

		ProductItem item1 = new ProductItem();
		item.setDesc("chinabone");
		item.setType("kitchen");
		item.setName("utensil");
		
		catalogue.addProduct(item);
		catalogue.addProduct(item1);

		Assert.assertEquals(catalogue.getProductListBasedOnType("kitchen").size(), 1);
	}

	@Test
	public void sadTest_AddToProductCatalogueService_2() throws ClassNotFoundException, SQLException, IOException {
		System.setProperty("cfg.file", "C:\\ProductCatalogueAndPricing\\ProductCatalogueService\\src\\webapp\\resources\\external\\cfg.properties");
		
		ProductCatalogue catalogue = new ProductCatalogue();
		
		ProductItem item = new ProductItem();
		item.setDesc("forbelow5yrs");
		item.setType("toys");
		item.setName("scalemodelcar");

		catalogue.removeProductFromCatalogue(item);

		Assert.assertEquals(catalogue.getProductListBasedOnType("toy").size(), 0);
	}
}
