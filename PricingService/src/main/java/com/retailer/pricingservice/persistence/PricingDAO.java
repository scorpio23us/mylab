package com.retailer.pricingservice.persistence;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.retailer.pricingservice.common.PropertyHelper;
import com.retailer.pricingservice.common.ServiceLocator;

public class PricingDAO {

	private static final String CFG_FILE = "cfg.file";
	private static PricingDAO dao = new PricingDAO();

	private Connection con;
	
	private PropertyHelper	propertyHelper;

	{
		try {
			con = establishDbConnection();
			triggerDbTableCreationIfDoesNotExist();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private PricingDAO() {/*Singleton so unexposed*/}
	
	public static PricingDAO getInstance() {
		return dao;
	}
	
	private Connection establishDbConnection() throws SQLException, ClassNotFoundException, IOException {

		if (con != null) {
			return con;
		}

		String propertiesFile = System.getProperty(CFG_FILE);
		propertyHelper = PropertyHelper.getInstance(propertiesFile);
		con = ServiceLocator.getInstance().getDBConnection(propertyHelper.getProperties(), propertyHelper.getDBProperties());

		return con;
	}

	private void triggerDbTableCreationIfDoesNotExist() throws IOException, ClassNotFoundException, SQLException {
		Statement stmt = con.createStatement();
		stmt.execute("create table IF NOT EXISTS productprice (barcodeid int "
				+ " , price BIGINT,"
				+ " primary key(barcodeid))");

		stmt.close();
	}

	public BigDecimal getPriceAgainstBarcode(int barcodeid) throws SQLException {
		Statement stmt = con.createStatement();
		BigDecimal price = new BigDecimal(BigInteger.ZERO);
		ResultSet rs = stmt.executeQuery("select barcodeid, price from productprice where barcodeid='"+ barcodeid +"'");
		while (rs.next()) {
			price = rs.getBigDecimal(2);
		}
		stmt.close();
		return price;
		
	}
}
