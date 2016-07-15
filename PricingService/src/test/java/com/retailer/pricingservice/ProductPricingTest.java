package com.retailer.pricingservice;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

import com.retailer.pricingservice.persistence.PricingDAO;

public class ProductPricingTest {

	@Test
	public void getProductPrice_fetchNoValue() throws ClassNotFoundException, SQLException, IOException {
		System.setProperty("cfg.file", "C:\\ProductCatalogueAndPricing\\ProductCatalogueService\\src\\webapp\\resources\\external\\cfg.properties");

		PricingDAO dao = PricingDAO.getInstance();
		System.out.println(dao.getPriceAgainstBarcode(1234));
	}

}
