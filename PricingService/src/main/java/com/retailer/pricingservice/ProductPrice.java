package com.retailer.pricingservice;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.retailer.pricingservice.persistence.PricingDAO;

@XmlRootElement
public class ProductPrice {

	public ProductPrice() {}

	@XmlElement
	public BigDecimal getPrice(int barcodeid) throws SQLException {
		PricingDAO persistence = PricingDAO.getInstance();
		return persistence.getPriceAgainstBarcode(barcodeid);
	}

}
