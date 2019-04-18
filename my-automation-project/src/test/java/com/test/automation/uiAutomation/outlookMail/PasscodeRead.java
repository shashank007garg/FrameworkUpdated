package com.test.automation.uiAutomation.outlookMail;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.ipmuiActions.OutlookLoginPage;
import com.test.automation.uiAutomation.testBase.TestBase;

public class PasscodeRead extends TestBase{

	OutlookLoginPage outlookloginpage;
	
	@BeforeClass
	public void setUp() throws IOException {

		init();
	}
	
	@Test
	public void passcodeRead() throws InterruptedException{
		outlookloginpage=new OutlookLoginPage(driver);
		outlookloginpage.loginOutlook();
		
		
	}
}
