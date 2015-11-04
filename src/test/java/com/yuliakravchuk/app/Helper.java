package com.yuliakravchuk.app;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptNextAlert = true;
	private WebDriverWait wait;

	public Helper(ApplicationManager manager){
		this.manager = manager;	
		this.driver = manager.driver;
		wait = new WebDriverWait(driver, 30);
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alert.getText();
		} finally {
			acceptNextAlert = true;
		}		
	}

	protected void type(By locator, String text) {
		WebElement element = wait.until(visibilityOfElementLocated(locator));
		if (text != null) {
			element.clear();		
			element.sendKeys(text);
		}
	}

	protected void click(By locator) {
		wait.until(visibilityOfElementLocated(locator)).click();
	}	
	
	protected String getText(By locator) {
		WebElement element = wait.until(visibilityOfElementLocated(locator));
		return element.getText();		
	}
	
//----------------------------------------------------------------------	
	/**
	 * Input email and password in login form and click Login
	 */	
	public void login(String email, String password) {
		click(By.className("be2-login"));  
		type(By.id("be2_login_username"),email);
		type(By.id("be2_login_password"),password);   
		click(By.id("be2_loginButton"));
	}
	
	/**
	 * Get login error message
	 */	
	public String getLoginError() {		 
		return getText(By.id("errorMsg"));		
	}	
	
	
}