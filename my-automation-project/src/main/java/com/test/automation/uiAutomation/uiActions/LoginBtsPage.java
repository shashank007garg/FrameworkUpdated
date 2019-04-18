package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

public class LoginBtsPage extends TestBase{

	WebDriver driver;

	public LoginBtsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='login']")
	WebElement userName;

	@FindBy(xpath = "//*[@name='passwd']")
	WebElement password;

	@FindBy(xpath = "//*[@id='mainloginbutton']")
	WebElement logIn;

	@FindBy(xpath = "//*[@id='b1']/table/tbody/tr[1]/td[2]/img")
	WebElement message;
	
	
	@FindBy(xpath = "//*[@id='mainMenu']/div[1]/ul[3]/li/a")
	WebElement logOut;

	public void loginApp(String userName, String password) {

		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		logIn.click();

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public String getMessage(){
		
		driver.switchTo().frame("main");
		String msg= message.getAttribute("title");
		driver.switchTo().defaultContent();
		return msg;
		
	}
	
	public void logOut(){
		
		driver.switchTo().frame("menu");
		System.out.println("under frame");
		logOut.click();
	}
}
