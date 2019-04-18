package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUp {
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;

	public SignUp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;

	@FindBy(xpath = "//*[@id='email_create']")
	WebElement emailAdd;

	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement createAccount;

	@FindBy(xpath = "//*[@id='uniform-id_gender1']")
	WebElement title;

	@FindBy(xpath = "//*[@id='customer_firstname']")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='customer_lastname']")
	WebElement lastName;

	@FindBy(xpath = "//*[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//*[@id='days']")
	WebElement day;

	@FindBy(xpath = "//*[@id='months']")
	WebElement month;

	@FindBy(xpath = "//*[@id='years']")
	WebElement year;

	@FindBy(xpath = "//*[@id='firstname']")
	WebElement fName;

	@FindBy(xpath = "//*[@id='lastname']")
	WebElement lName;

	@FindBy(xpath = "//*[@id='address1']")
	WebElement adderess;

	@FindBy(xpath = "//*[@id='city']")
	WebElement city;

	@FindBy(xpath = "//*[@id='id_state']")
	WebElement state;

	@FindBy(xpath = "//*[@id='postcode']")
	WebElement postCode;

	@FindBy(xpath = "//*[@id='id_country']")
	WebElement country;

	@FindBy(xpath = "//*[@id='phone_mobile']")
	WebElement mobileNumber;

	@FindBy(xpath = "//*[@id='alias']")
	WebElement alias;
	
	@FindBy(xpath = "//*[@id='submitAccount']")
	WebElement submitAccount;

	public void signUpPage(String emailAdd, String password, String firstName,
			String lastName, String city, String adderess, String day,
			String month, String year, String state, String postCode,
			String mobileNumber) {

		signIn.click();
		this.emailAdd.sendKeys(emailAdd);
		createAccount.click();
		title.click();
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.password.sendKeys(password);
		Select days = new Select(this.day);
		days.selectByValue(day);
		Select months = new Select(this.month);
		months.selectByValue(month);
		Select years = new Select(this.year);
		years.selectByValue(year);
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		this.adderess.sendKeys(adderess);
		this.city.sendKeys(city);
		Select statename = new Select(this.state);
		statename.selectByValue(state);
		this.postCode.sendKeys(postCode);
		this.mobileNumber.sendKeys(mobileNumber);
		alias.clear();
		alias.sendKeys(emailAdd);
		submitAccount.click();

	}
	
	public String getRegistrationSuccessMessage(){
		return driver.getTitle();
		
	}

}
