package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC004_VerifyNavigationPage extends TestBase{
	HomePage homepage;
	
	@BeforeClass
	public void setUp() throws IOException {

		init();
	}
	@Test
	public void navigationTest() throws InterruptedException {
		homepage = new HomePage(driver);
		//homepage.clickOnDressNavigationMenu("Casual Dresses");
		homepage.clickOnWomenNavigationMenu("Tops");
		
		
	}
	
	
	
	
}
