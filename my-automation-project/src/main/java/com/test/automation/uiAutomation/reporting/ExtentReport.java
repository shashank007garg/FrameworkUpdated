package com.test.automation.uiAutomation.reporting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.testBase.TestBase;

public class ExtentReport extends TestBase{
	
	
	public static void reportPath(){
		extent = new ExtentReports(
				System.getProperty("user.dir")
						+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\report\\test.html",
				false);
	}
	
	public static void closeBrowser() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}
	
	public static void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + "test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName()
					+ "test is skip and skip reason is" + result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, test.addScreenCapture(captureScreen("")));
		}

		else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + "test is started");
		}
	}
	
	private static String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");

		File srcfile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir"))
					.getAbsolutePath()
					+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\screenshot\\";
			destFile = new File((String) reportDirectory + fileName + "_"
					+ formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcfile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath()
					+ "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/></a>");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();

	}
}
