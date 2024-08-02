package com.Applications.Amazon.uimap;

import org.openqa.selenium.By;

public class Amazon_UIMap {

	public static class login{
		public static  By btn_SignIn=By.xpath("//a[@id='nav-link-accountList']");
		public static  By btn_continue=By.xpath("//input[@id='continue']");
		public static  By email_input=By.xpath("//input[@type='email']");
		public static  By password_input=By.xpath("//input[@id='ap_password']");
		public static By btn_signInSubmit=By.xpath("//input[@id='signInSubmit']");
		
	}

}
