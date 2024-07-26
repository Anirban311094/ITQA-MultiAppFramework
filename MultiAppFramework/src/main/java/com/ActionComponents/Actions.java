package com.ActionComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
	public static WebDriver driver;
	private static final int DEFAULT_WAIT_TIME = 10; // seconds
	
	void waitUntilDisplayed(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 

    }
	public static void waitUntilClickable(By arg, int optionalWaitTimeinMiliSec) {
        int waitTime = (optionalWaitTimeinMiliSec > 0) ? optionalWaitTimeinMiliSec / 1000 : DEFAULT_WAIT_TIME;
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(arg));
    }
	
	
	
	public static void switchToTab(String direction) {
		TabManager tabManager=new TabManager();
        List<String> tabs = (List<String>) driver.getWindowHandles();
        int tabCount = tabs.size();

        if (tabCount <= 1) {
            return; // No tabs to switch
        }

        String directionLower = direction.toLowerCase();

        switch (directionLower) {
            case "left":
            case "l":
                if (tabManager.getCurrentTabIndex() > 0) {
                    tabManager.setCurrentTabIndex(tabManager.getCurrentTabIndex() - 1);
                    driver.switchTo().window(tabs.get(tabManager.getCurrentTabIndex()));
                }
                break;
            case "right":
            case "r":
                if (tabManager.getCurrentTabIndex() < tabCount - 1) {
                    tabManager.setCurrentTabIndex(tabManager.getCurrentTabIndex() + 1);
                    driver.switchTo().window(tabs.get(tabManager.getCurrentTabIndex()));
                } else {
                    tabManager.setCurrentTabIndex(0);
                    driver.switchTo().window(tabs.get(tabManager.getCurrentTabIndex()));
                }
                break;
            case "default":
            case "d":
                tabManager.setCurrentTabIndex(0);
                driver.switchTo().window(tabs.get(tabManager.getCurrentTabIndex()));
                break;
            case "start":
            case "s":
                tabManager.setCurrentTabIndex(0);
                driver.switchTo().window(tabs.get(tabManager.getCurrentTabIndex()));
                break;
            case "end":
            case "e":
                tabManager.setCurrentTabIndex(tabCount - 1);
                driver.switchTo().window(tabs.get(tabManager.getCurrentTabIndex()));
                break;
            default:
            	System.out.println("Error: switchToTab(String): Please provide valid input parameter ie:\r\n "
            			+ "left or L: Switches to the previous tab.\r\n"
            			+ "right or R: Switches to the next tab. If it's the last tab, it switches to the first tab.\r\n"
            			+ "default or D: Switches to the first tab.\r\n"
            			+ "start or S: Switches to the first tab (same as default).\r\n"
            			+ "end or E: Switches to the last tab.");
                break;
        }
    }

    public static void switchToTab(WebDriver driver, TabManager tabManager, int index) {
        List<String> tabs = (List<String>) driver.getWindowHandles();
        int tabCount = tabs.size();

        if (index >= 0 && index < tabCount) {
            tabManager.setCurrentTabIndex(index);
            driver.switchTo().window(tabs.get(index));
        } else {
            // Handle invalid index
        }
    }
	
	
}


