package com.Applications.Google.bussinesscomponents;

import com.ActionComponents.*;
import com.Applications.Google.uimap.Google_UIMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Results.GenerateReport.PassInfos;
//import com.Results.GenerateReport.Report;
//import com.Results.GenerateReport.Status;

public class Google_Keywords {
    public static WebDriver driver;
   
//    private Report report;
//
//    public void setReport(Report report) {
//        this.report = report;
//    }
    
    public void login() throws Exception {
        try {
        	String url=PassInfos.getProperty("url");
        	String UserName=PassInfos.getProperty("UserName");
        	String password=PassInfos.getProperty("Password");
        	
            driver.get(url);
            Thread.sleep(5000);
            String title=driver.findElement(Google_UIMap.login.title).getText().trim();
            System.out.println("Title: "+title);
            String header1=driver.findElement(Google_UIMap.login.header1).getText().trim();
            System.out.println("Header 1: "+header1);
            String header2=driver.findElement(Google_UIMap.login.header2).getText().trim();
            System.out.println("Header 2: "+header2);
            
            driver.findElement(By.xpath(UserName)).click();
            Thread.sleep(5000);
            
            WebElement emailField = driver.findElement(Google_UIMap.login.email_input);
            emailField.sendKeys("your.email@gmail.com");

            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Next']")).click();
            Thread.sleep(3000);
            
            driver.findElement(By.xpath("//span[text()='Try another way']")).click();
            
            Actions.waitUntilClickable(By.xpath("//div[text()='Enter your password']"), 5000);
            
            driver.findElement(By.xpath("//div[text()='Enter your password']")).click();
            
            Actions.waitUntilClickable(Google_UIMap.login.password_input, 5000);
            
            WebElement passwordField = driver.findElement(Google_UIMap.login.password_input);
            passwordField.sendKeys(password);

            driver.findElement(By.xpath("//span[text()='Next']//ancestor::button")).click();
            
            Actions.waitUntilClickable(By.xpath("//div[text()='You’re signed in']"), 5000);
            
            WebElement signIn_confirm=driver.findElement(By.xpath("//div[text()='You’re signed in']"));
            
            driver.findElement(By.xpath("//span[text()='Not now']//ancestor::button")).click();
            
            Actions.waitUntilClickable(By.xpath("//h1[contains(text(), 'Welcome,')]"), 5000);
            
            if(Sync.isElementDisplayed(By.xpath("//h1[contains(text(), 'Welcome,')]"))) {
            	System.out.println("Login Successfull...");
            }else {
            	System.out.println("Login Failed...");
            }
            String welcomeMsg=driver.findElement(By.xpath("//h1[contains(text(), 'Welcome,')]")).getText().trim();
            System.out.println("Welcome Message: "+welcomeMsg);
            
            
//          report.updateTestLog("Step 1", "Step description 1", Status.PASS);
//          report.updateTestLog("Step 2", "Step description 2", Status.FAIL);
//          report.updateTestLog("Step 2", "Take screenshot: Step description 2", Status.SCREENSHOT);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during the login process!");
        }
    }
}
