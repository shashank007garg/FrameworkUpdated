package com.test.automation.uiAutomation.registrationPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.SignUp;

public class TC002_SignUpPage extends TestBase {

	SignUp signup;

	@BeforeTest
	public void setUp() throws IOException {

		init();
	}

	@Test
	public void signUpPage() throws InterruptedException {

		try {
			log.info("----Starting registration page");
			signup = new SignUp(driver);
			signup.signUpPage("testgarg7@gmail.com", "shashank2123", "shashank",
					"garg", "NEW YORK", "A-53 new york", "20", "1", "1988",
					"1", "35006", "8888888888");

			Assert.assertEquals("My account - My Store",
					signup.getRegistrationSuccessMessage());
		} catch (Exception e) {

		}

	}

	@AfterClass
	public void endTest() {
		driver.close();
	}

}
