package com.test.automation.uiAutomation.contractManagementPage;

import java.io.IOException;


import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.LoginBtsPage;

public class ContractManagementPage extends TestBase{

	LoginBtsPage loginbtspage;
	
	
	@BeforeClass
	public void setUp() throws IOException {

		init();
	}
	
	@Test
	public void loginTest(){
		loginbtspage=new LoginBtsPage(driver);
		//loginbtspage.loginApp(LoginPage.User_Name, LoginPage.Password);
		Assert.assertTrue(loginbtspage.isAlertPresent());
		//Assert.assertEquals(LoginPage.message, loginbtspage.getMessage());
		loginbtspage.logOut();
	}
}
