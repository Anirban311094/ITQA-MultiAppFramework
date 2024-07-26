package com.Applications.Google.uimap;

import org.openqa.selenium.By;
//Google_UIMap.login.title
public class Google_UIMap {
	public static class login{
		public static By title=By.xpath("//title");
		public static  By header1=By.xpath("//h1[@id='headingText']/span");
		public static  By header2=By.xpath("//h1[@id='headingText']//following::div[1]/span");
		public static  By email_input=By.xpath("//input[@type='email']");
		public static  By password_input=By.xpath("//input[@type='email']");
	}
}
