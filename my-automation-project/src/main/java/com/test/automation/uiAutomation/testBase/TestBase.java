package com.test.automation.uiAutomation.testBase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.reporting.ExtentReport;
import com.test.automation.uiAutomation.utilities.Config;
import com.test.automation.uiAutomation.utilities.Excel_Reader;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public static WebDriver driver;
	Excel_Reader reader;
	public static Properties OR;
	public static ExtentReports extent;
	public static ExtentTest test;

	public ITestResult result;
	

	public void init() throws IOException {
		Config.loadData();
		ExtentReport.reportPath();
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"drivers/chromedriver.exe");
			log.info("creating object of " + browser);

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"drivers/geckodriver.exe");
			log.info("creating object of " + browser);
			driver = new FirefoxDriver();

		}
	}

	public void getUrl(String url) {
		log.info("navigating to" + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String[][] getData(String sheetName, String excelName) {
		String path = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\data\\"
				+ excelName;
		reader = new Excel_Reader(path);
		String[][] data = reader.getDataFromSheet(sheetName);
		return data;
	}

	
	@BeforeMethod()
	public void beforeMethod(Method method) {
		test = extent.startTest(method.getName());
		test.log(LogStatus.INFO, method.getName() + "test Started");
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) {
		ExtentReport.getResult(result);
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		ExtentReport.closeBrowser();
	}
}
