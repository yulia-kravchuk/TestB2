package com.yuliakravchuk.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;	
	
	private Helper helper;
	
	public ApplicationManager() {
		driver = new FirefoxDriver();							
		baseUrl = "http://www.be2.co.uk";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.get(baseUrl);
	}
	
	public void refresh() {    
		driver.get(baseUrl);
	}
	
	
	public void stop() {
		driver.quit();
	}	
	
	public Helper getHelper() {
		if (helper == null) {
			helper = new Helper(this);
		}
		return helper;
	}
}