package com.test.automation.uiAutomation.uiActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

public class ProductDetailsPage extends TestBase{
	
	
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[1]/div")
	List<WebElement> products;
	
	public void selectProduct(String productName) throws InterruptedException{
		driver.findElement(By.xpath("//a[contains(text(),'"+productName+"')]")).click();
		Thread.sleep(3000);
	}
	
	
	public List<WebElement> selectProduct(){
		List<WebElement> element = products;
	return element;
	
	
	}
}
