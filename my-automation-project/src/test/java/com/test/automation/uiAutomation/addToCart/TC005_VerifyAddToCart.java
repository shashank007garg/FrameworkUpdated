package com.test.automation.uiAutomation.addToCart;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;


import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.test.automation.uiAutomation.constants.IPProps.DetailsPage;
import com.test.automation.uiAutomation.constants.IPProps.MainPage;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.AddToCartPage;
import com.test.automation.uiAutomation.uiActions.HomePage;
import com.test.automation.uiAutomation.uiActions.ProductDetailsPage;

public class TC005_VerifyAddToCart extends TestBase {
	HomePage homepage;
	ProductDetailsPage productdetailspage;
	AddToCartPage addtocartpage;

	@BeforeClass
	public void setUp() throws IOException {

		init();
	}

	@Test
	public void verifyAddToCart() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickOnDressNavigationMenu(MainPage.Summer_Dresses);
		productdetailspage = new ProductDetailsPage(driver);
		productdetailspage.selectProduct(DetailsPage.Printed_Summer_Dress);
		addtocartpage = new AddToCartPage(driver);
		addtocartpage.twitterLink();

//		Iterator<String> Iterator = getAllWindows();
//		String parentWindow = Iterator.next();
//		String childWindow = Iterator.next();

		//driver.switchTo().window(childWindow);
		boolean status = addtocartpage.verifyTwitterMessage();
		Assert.assertEquals(true, status);
		//driver.switchTo().window(parentWindow);

		addtocartpage.addToCart();
		Thread.sleep(3000);

	}

	
}
