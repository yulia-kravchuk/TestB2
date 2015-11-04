package com.yuliakravchuk.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test login feature
 */
public class LoginTest
	extends TestBase
{	
    /**
     * Login with correct credentials
     */  
	@Test
    public void testLoginWithCorrectCredentials() 
    {          	
		app.getHelper().login("testingtonb2@gmail.com","look4destiny");               
        assertTrue(app.driver.getCurrentUrl().startsWith("http://app.be2.co.uk/member/member/index?isLogin=true#"));
    }
    
	/**
	 * Login with incorrect password
	 */	
	@Test
    public void testLoginWithIncorrectPassword() 
    {      
		app.getHelper().login("testingtonb2@gmail.com","look4destiny1");                         
        assertTrue(app.driver.getCurrentUrl().equals("http://www.be2.co.uk/#"));
    }
    
	/**
	 * Login without password specified
	 */	
	@Test
    public void testLoginWithoutPassword() 
    {      
		app.getHelper().login("testingtonb2@gmail.com","");        
                
        assertTrue(app.getHelper().getLoginError().equals("Email address and password do not match"));        
        assertTrue(app.driver.getCurrentUrl().endsWith("/login/auth?login_error=1"));
    }    
}
