package com.retailer.pricingservice;

import java.math.BigDecimal;

public class PricingProductItems {
	private int barcodeid;
	private BigDecimal price;
	
	public int getBarcodeid() {
		return barcodeid;
	}

	public BigDecimal getPrice() {
		return new BigDecimal(price.toBigInteger());
	}

	public PricingProductItems(int barcodeid, BigDecimal price) {
		this.barcodeid = barcodeid;
		this.price = price;
	}
	
}
