package com.ActionComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sync {
	public static WebDriver driver;
	private static final int DEFAULT_WAIT_TIME = 10; // seconds
	
	
	public static boolean isElementDisplayed(By arg) {
        try {
            WebElement element = driver.findElement(arg);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	public static boolean isElementClickable(By arg) {
		try {
            WebElement element = driver.findElement(arg);
            return element.isEnabled() && element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
}
