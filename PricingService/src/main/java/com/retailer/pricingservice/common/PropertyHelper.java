package com.retailer.pricingservice.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import com.retailer.pricingservice.common.PropertyHelper;

public class PropertyHelper {

    private static PropertyHelper instance = new PropertyHelper();
    private Properties props;
    private Properties dbProps;
    
    private static String prevPropertiesFile = "";	
	
    private PropertyHelper(){
    }
	
    public static PropertyHelper getInstance(final String propertiesFile) throws IOException {
		if ( fileExists(propertiesFile) && isFile(propertiesFile) ) {
			if (instance.props == null || !prevPropertiesFile.equals(propertiesFile)) {
    		
	    		instance.props = new Properties ();
		        instance.props.load(new FileInputStream(propertiesFile));
			    instance.dbProps = new Properties();

			    for (Enumeration e = instance.props.keys() ; e.hasMoreElements() ;) {
			    	String key = (String)e.nextElement();
			    	instance.dbProps.put(key, instance.props.get(key));
			    }
			}
		} else {
			throw new IOException ("Unable to find properties file:" + propertiesFile);
		}
    	prevPropertiesFile = propertiesFile;
    	
        return instance;
    }
    
    private static boolean isFile(String fileName) {
	    File file = new File(fileName);		
	    
	    if (!file.isFile()) {
	    	return false;
	    } else {
	    	return true;
	    }
    }

	private static boolean fileExists(String fileName) {
	    if (fileName == null) {
	    	return false;
	    }
	    File file = new File(fileName);		
	    
	    if (!file.exists()) {
	    	return false;
	    } else if (!file.isFile()) {
	    	return false;
	    } else {
	    	return true;
	    }
	}

    public String getProperty (final String key) {
    	return props.getProperty(key);
    }

	public Properties getProperties () {
		return props;
	}
	
	public Properties getDBProperties () {
		return dbProps;
	}
	
}
