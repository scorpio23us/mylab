package com.retailer.productcatalogueservice.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ServiceLocator {
    private static ServiceLocator instance = new ServiceLocator();
	
    private ServiceLocator () {}
	
    public static ServiceLocator getInstance() throws IOException {
        return instance;
    }

	public Connection getDBConnection (final Properties properties, final Properties dbProperties) throws ClassNotFoundException, 
	                        SQLException, IOException {
		Connection conn = null;
		Class.forName(properties.getProperty("db.driverName"));
		conn = DriverManager.getConnection(properties.getProperty("db.URL"), dbProperties);
		return conn;
	}

}
