package com.Applications.Google.bussinesscomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Results.GenerateReport.Report;
import com.Results.GenerateReport.Status;

public class Google_Keywords {
	
    public static WebDriver driver;
//    private Report report; // Reference to report object
//
//    public void setReport(Report report) {
//        this.report = report;
//    }
    
    public void login() throws Exception {
        try {
            // Open LinkedIn login page
            driver.get("https://in.linkedin.com/");
            Thread.sleep(5000);
            // Click on Sign in button
            driver.findElement(By.xpath("//input[@type='email']")).click();
            Thread.sleep(5000);
            
//            report.updateTestLog("Step 1", "Open browser", Status.PASS);
//            report.updateTestLog("Step 2", "Navigate to URL", Status.PASS);
//            report.updateTestLog("Step 4", "Take screenshot", Status.SCREENSHOT);
           
            
            WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
            emailField.sendKeys("anirbanc1994@gmail.com");

            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Next']")).click();
            Thread.sleep(5000);
            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.sendKeys("password");

            driver.findElement(By.xpath("//span[text()='Next']")).click();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during the login process!");
        }
    }
}
