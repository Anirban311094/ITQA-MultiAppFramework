package com.Applications.Amazon;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//com.Applications.Amazon.PropertyHandle
public class PropertyHandle {
	private static final String PROPERTIES_FILE_PATH = "C:\\Users\\Rahul Chakrabarty\\git\\ITQA-MultiAppFramework\\MultiAppFramework\\src\\main\\java\\com\\Applications\\Amazon\\Amazonproperty.properties"; // Update the path

    public String getProperties() {
    	return PROPERTIES_FILE_PATH;
    }
    
    public static String getProperty(String  key) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
        	System.out.println("getProperty:\n"+e.getLocalizedMessage()+"\n"+e.getMessage()+"\n"+e.getCause()+"\n"+e.getStackTrace());
            e.printStackTrace();
            return null;
        }
    }
}
