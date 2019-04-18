package com.test.automation.uiAutomation.customListener;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class WebEventListener extends AbstractWebDriverEventListener implements WebDriverEventListener{

	public static final Logger log=Logger.getLogger(WebDriverEventListener.class.getName());
	
	@Override
	public void afterAlertAccept(WebDriver arg0) {
		
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		
		log("Element value changed to :"+element.toString());
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		log("clickedon :"+element.toString());
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log("found element By :"+by.toString());
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		log("Navigated to:'"+url+"'");
		
	}

	private void log(String data) {
		log.info(data);
		Reporter.log(data);
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		
		log("value of the :"+element.toString()+"before any changes made");
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		log("Trying to click on :"+element.toString());
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log("Trying to find element By :"+by.toString());
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		//log("Before Navigating to:'"+url+"'");
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		
		
	}

	
}
