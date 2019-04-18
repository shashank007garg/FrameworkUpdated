package com.test.automation.uiAutomation.ipmuiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.utilities.BasePageObject;

public class LoginIpmPage extends TestBase {

	WebDriver driver;

	public LoginIpmPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='Login']")
	WebElement userName;

	@FindBy(xpath = "//*[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//*[@id='submitBtn']")
	WebElement submit;

	@FindBy(xpath = "//*[@id='logoutForm']/ul[2]/li[1]/a/span")
	WebElement message;

	public void loginApp(String userName, String password) {

		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		submit.click();

	}
/*we are checking message*/
	public String getMessage() {

		BasePageObject.waitForElement(20, message);
		String msg = message.getText();
		System.out.println(msg);
		return msg;

	}
}
