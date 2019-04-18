package com.test.automation.uiAutomation.uiActions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.utilities.BasePageObject;

public class AddToCartPage extends TestBase {

	@FindBy(xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[2]")
	WebElement facebookLiink;
	@FindBy(xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[1]")
	WebElement tweet;
	@FindBy(xpath = "//*[@id='center_column']/div/div/div[3]/p[7]/button[4]")
	WebElement printRest;

	@FindBy(xpath = "//*[@id='add_to_cart']/button")
	WebElement addToCart;

	@FindBy(xpath="//*[contains(text(),'What’s happening?')]")
	WebElement twitterMessage;
	
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void facebbokLink() {
		facebookLiink.click();
	}

	public void twitterLink() {
		tweet.click();
	}
	
	public void addToCart() {
		BasePageObject.waitForElement(30, addToCart);
		addToCart.click();
	}
	public boolean verifyTwitterMessage(){
		
		
		try {
			twitterMessage.isDisplayed();
			return true;
		} catch (Exception e) {
		return false;
		}
	}
	
	
}
