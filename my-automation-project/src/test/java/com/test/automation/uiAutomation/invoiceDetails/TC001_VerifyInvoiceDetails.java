package com.test.automation.uiAutomation.invoiceDetails;

import java.awt.AWTException;
import java.io.IOException;









import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.constants.IPMPageConstant;
import com.test.automation.uiAutomation.ipmuiActions.LoginIpmPage;
import com.test.automation.uiAutomation.ipmuiActions.SearchandHeaderDetailsPage;
import com.test.automation.uiAutomation.testBase.TestBase;

public class TC001_VerifyInvoiceDetails extends TestBase{
	LoginIpmPage loginipmpage;
	SearchandHeaderDetailsPage searchheaderdetailspage;
	
	@DataProvider(name="HeaderDetails")
	public String[][] getHeaderDetails(){
		String[][] testrecords=getData("HeaderDetails","Login.xlsx");
		return testrecords;
		
	}
	
	@BeforeClass
	public void setUp() throws IOException {

		init();
	}
	
	@Test
	@Parameters({"username","password"})
	public void login(String username,String password){
		loginipmpage=new LoginIpmPage(driver);
		loginipmpage.loginApp(username, password);
		Assert.assertTrue(loginipmpage.getMessage().equals(IPMPageConstant.USER_NAME.value()));
		
		
	}
	
	@Test(dependsOnMethods="login",dataProvider="HeaderDetails")
	public void headerDetails(String...args  ) throws InterruptedException, AWTException, IOException{
		searchheaderdetailspage=new SearchandHeaderDetailsPage(driver);
		searchheaderdetailspage.selectNetwork(args[0]);
		searchheaderdetailspage.selectBatch(args[1]);
		searchheaderdetailspage.searchAndClick(args[2],args[3]);
		System.out.println("detailspage");
		
		
		searchheaderdetailspage.headerMatch(args[2],args[3],args[4],args[5],args[6],args[7]);
		
		
	}

}
