package com.yuliakravchuk.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Unit test for simple App.
 */
public class LoginTest 
    extends TestCase
{
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	  //@Before
	public void setUp() throws Exception {
	  driver = new FirefoxDriver();
	  baseUrl = "http://www.be2.co.uk";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get(baseUrl + "/");
	}
	  
	  
	
//    /**
//     * Create the test case
//     * @param testName name of the test case
//     *
//     */
//    public LoginTest( String testName )
//    {
//        super( testName );
//    }
//
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LoginTest.class );
    }

    /**
     * Rigorous Test :-)
     */    
    public void testLoginWithCorrectCredentials() //throws Exception
    {          	
        login("testingtonb2@gmail.com","look4destiny");               
        assertTrue(driver.getCurrentUrl().startsWith("http://app.be2.co.uk/member/member/index?isLogin=true#"));
    }



	/**
	 * 
	 */
	public void login(String email, String password) {
		driver.findElement(By.className("be2-login")).click();        
        driver.findElement(By.id("be2_login_username")).clear();
        driver.findElement(By.id("be2_login_username")).sendKeys(email);
        driver.findElement(By.id("be2_login_password")).clear();
        driver.findElement(By.id("be2_login_password")).sendKeys(password);
        driver.findElement(By.id("be2_loginButton")).click();
	}
    
    public void testLoginWithIncorrectPassword() //throws Exception
    {      
    	login("testingtonb2@gmail.com","look4destiny1");                         
        assertTrue(driver.getCurrentUrl().equals("http://www.be2.co.uk/#"));
    }
    
    public void testLoginWithoutPasswordSpecified() //throws Exception
    {      
    	login("testingtonb2@gmail.com","");        
                
        assertTrue(driver.findElement(By.id("errorMsg")).getText().equals("Email address and password do not match"));        
        assertTrue(driver.getCurrentUrl().equals("http://app.be2.co.uk/login/auth?login_error=1"));
    }
    
    //@After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }    
}
