package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath = "//*[@id='email']")
	WebElement userName;
	
	@FindBy(xpath = "//*[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath = "//*[@id='SubmitLogin']")
	WebElement logIn;
	
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logOut;
	
	public void loginApp(String userName,String password) {
		signIn.click();
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		logIn.click();
		
		
	}
	
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   
	} 
	
	public String getRegistrationSuccessMessage(){
		return driver.getTitle();
		
	}
	
	public void logOut(){
		logOut.click();
	}
	
}
