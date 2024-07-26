package com.Results.GenerateReport;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PassInfos {

    private static final String PROPERTIES_FILE_PATH = "F:\\Project Workspace\\MultiAppFramework\\MultiAppFramework\\src\\main\\java\\com\\DataTables\\Settings.properties"; // Update the path

    public String getProperties() {
    	return PROPERTIES_FILE_PATH;
    }
    
    public static String getCurrentTestCaseName() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(inputStream);
            return properties.getProperty("CurrentTestCaseName");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String getProperty(String  key) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(inputStream);
            return properties.getProperty("CurrentTestCaseName");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setCurrentTestCaseName(String testCaseName) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(inputStream);
        }
        properties.setProperty("CurrentTestCaseName", testCaseName);

        try (FileOutputStream outputStream = new FileOutputStream(PROPERTIES_FILE_PATH)) {
            properties.store(outputStream, null);
        }
    }
}
