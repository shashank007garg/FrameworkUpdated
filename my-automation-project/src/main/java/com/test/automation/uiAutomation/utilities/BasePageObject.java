package com.test.automation.uiAutomation.utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.automation.uiAutomation.testBase.TestBase;

public class BasePageObject extends TestBase {
	public static void waitForElement(int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void getScreenShot(String name) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");

		File srcfile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir"))
					.getAbsolutePath()
					+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\screenshot\\";
			File destFile = new File((String) reportDirectory + name + "_"
					+ formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcfile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath()
					+ "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/></a>");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void entirePageScreenshot(String name) throws AWTException,
			IOException {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");

		String reportDirectory = new File(System.getProperty("user.dir"))
				.getAbsolutePath()
				+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\screenshot\\";
		File destFile = new File((String) reportDirectory + name + "_"
				+ formater.format(calendar.getTime()) + ".png");
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(
				Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", destFile);
	}
	
	public Iterator<String> getAllWindows() {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> Iterator = window.iterator();
		return Iterator;
	}
	
}
