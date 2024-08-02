package com.Applications.Amazon.bussinesscomponents;


import com.ActionComponents.*;
import com.Applications.Amazon.PropertyHandle;
import com.Applications.Amazon.uimap.Amazon_UIMap;
import com.Applications.Google.uimap.Google_UIMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import com.Results.GenerateReport.PassInfos;

public class Amazon_Keywords {

    public static WebDriver driver;//=com.Applications.DriverSetter.getDriver();
   
//    private Report report;
//
//    public void setReport(Report report) {
//        this.report = report;
//    }
    
    public void login() throws Exception {
    	System.out.println("Amazon login 1");
    	String url=PropertyHandle.getProperty("AmazonURL");
    	String userName=PropertyHandle.getProperty("AmazonUserId");
    	String password=PropertyHandle.getProperty("AmazonPassword");
    	System.out.println("url: "+url+", user: "+userName);
        driver.get(url);
        Thread.sleep(5000);
        driver.findElement(Amazon_UIMap.login.btn_SignIn).click();
        
        Actions.waitUntilClickable(Amazon_UIMap.login.email_input, 5000);
        driver.findElement(Amazon_UIMap.login.email_input).sendKeys(userName);
        driver.findElement(Amazon_UIMap.login.btn_continue).click();
        Actions.waitUntilClickable(Amazon_UIMap.login.password_input, 5000);
        driver.findElement(Amazon_UIMap.login.password_input).sendKeys(password);
        driver.findElement(Amazon_UIMap.login.btn_signInSubmit).click();
        
        
    }

}
