package com.test.automation.uiAutomation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.test.automation.uiAutomation.testBase.TestBase;

public class Config extends TestBase{
	
	public static void loadData() throws IOException {
		OR = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir")
						+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\config\\config.properties");

		OR.load(file);
	}
}
