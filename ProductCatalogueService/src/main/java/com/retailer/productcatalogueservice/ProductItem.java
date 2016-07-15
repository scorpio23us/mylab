package com.retailer.productcatalogueservice;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductItem {

	private String type;
	private String name;
	private String desc;
	private int barcodeid;

	public ProductItem() {}
	//public ProductItem() {//int barcodeId, String name, String type, String desc) {
/*		this.type = type;
		this.name = name;
		this.desc = desc;
		this.barcodeid = barcodeId;
*/	//}

	@XmlElement
	public void setType(String type) {
        this.type = type;
	}

	@XmlElement
	public void setName(String name) {
        this.name = name;
	}

	public String getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	@XmlElement
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}
	
	public int getBarcodeid() {
		return barcodeid;
	}
	
	public void setBarcodeid(int barcodeid) {
		this.barcodeid = barcodeid;
	}
	
}
