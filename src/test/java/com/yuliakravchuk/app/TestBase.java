package com.yuliakravchuk.app;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestBase {
	
	protected static ApplicationManager app;	

	@BeforeClass
	public static void setUpClass() throws Exception {		
		app = new ApplicationManager();			
	}
	
	@Before
	public void setUp() throws Exception {	  
	  app.refresh();
	}	
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		app.stop();
	}
}