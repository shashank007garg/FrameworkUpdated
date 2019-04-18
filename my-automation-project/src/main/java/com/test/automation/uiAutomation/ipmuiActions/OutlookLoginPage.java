package com.test.automation.uiAutomation.ipmuiActions;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

public class OutlookLoginPage extends TestBase{

	WebDriver driver;
	
	public OutlookLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="i0116")
	WebElement signIn;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement next;
	
	@FindBy(xpath="//span[contains(@class,'outlookLogoFill')]")
	WebElement outlookIcon;
	
	@FindBy(css="span[class='_db_m2']")
	WebElement filterArrow;
	
	@FindBy(xpath="//span[text()='Unread']")
	WebElement unreadLnk;
	
	public void loginOutlook() throws InterruptedException{
		signIn.sendKeys("shashank.garg@viacomcontractor.com");
		next.click();
		outlookIcon.click();
		
		 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//		 List<WebElement> frame=driver.findElements(By.tagName("iframe"));
//		 for(WebElement name:frame){
//			 System.out.println(name.getText());
//		 }
//		 int size=frame.size();
//		 
//		 for(int i=0;i<=size;i++){
//			 
//			 driver.switchTo().frame(i);
//			 filterArrow.click();
//			 
//		 }
		 //driver.switchTo().frame(1);
//		 WebDriverWait wait=new WebDriverWait(driver,10);
//		 wait.until(ExpectedConditions.elementToBeClickable(filterArrow));
		Thread.sleep(10000);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	@SuppressWarnings("unchecked")
	List<WebElement> element= (List<WebElement>) executor.executeScript("return document.getElementsByTagName('span')");
	System.out.println(element.size());
	for(WebElement ele:element){
		System.out.println(ele.getText());
	}
		
		
		// filterArrow.click();
		 unreadLnk.click();
		 
		 
		 List<WebElement> email = driver.findElements(By.cssSelector("#divSubject"));

		 for(WebElement emailsub : email){

		     if(emailsub.getText().equals("<email subject>") == true){
		            emailsub.click();
		            break;
		         }
		     }
		 
		
	}
	
	
	
}
