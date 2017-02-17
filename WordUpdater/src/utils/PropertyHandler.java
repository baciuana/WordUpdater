package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {
	
	private static PropertyHandler instance = null;
	private Properties userProperties = null;
	protected static final String USERPROP = "user.properties";
	
	private PropertyHandler() {
		userProperties = new Properties();
		
		try {
			 userProperties.load(new FileInputStream(USERPROP));
		    	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized PropertyHandler getInstance() {
		if (instance == null) {
			instance = new PropertyHandler();
		}
		return instance;
	}
	
	public String getProperty(String key) {
		if (userProperties.containsKey(key)) {
			return userProperties.getProperty(key);
		}
		return null;
	}
	
	public void setProperty(String key, String value) {
		userProperties.setProperty(key, value);
	}
	
	public void saveProperties() {
		try {
			FileOutputStream out = new FileOutputStream(USERPROP);
			userProperties.store(out, "RCR user properties");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
