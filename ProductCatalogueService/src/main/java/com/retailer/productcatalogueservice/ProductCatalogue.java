package com.retailer.productcatalogueservice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.retailer.productcatalogueservice.persistence.ProductCatalogueDAO;

public final class ProductCatalogue {

	private static ProductCatalogueDAO persistence = ProductCatalogueDAO.getInstance();
	
	public void addProduct(ProductItem item) throws ClassNotFoundException, SQLException, IOException {
        persistence.insert(item);
	}

	public List<ProductItem> getAllProductsFromCatalogue() throws ClassNotFoundException, SQLException, IOException {
        return persistence.selectProducts();
	}

	public List<ProductItem> getProductListBasedOnType(String type) throws ClassNotFoundException, SQLException, IOException {
        return persistence.selectProductsBasedOnType(type);
	}

	public void removeProductFromCatalogue(ProductItem item) throws ClassNotFoundException, SQLException, IOException {
        persistence.removeProduct(item);
	}

}