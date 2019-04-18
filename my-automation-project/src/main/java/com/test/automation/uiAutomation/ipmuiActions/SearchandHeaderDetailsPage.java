package com.test.automation.uiAutomation.ipmuiActions;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.utilities.BasePageObject;

public class SearchandHeaderDetailsPage extends TestBase {

	SoftAssert s_assert;
	WebDriver driver;
	public SearchandHeaderDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		s_assert = new SoftAssert();
	}

	@FindBy(xpath = "//*[@id='Login']")
	WebElement userName;

	@FindBy(xpath = "//*[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//*[@id='SelectedNetwork']")
	WebElement selectNetwork;

	@FindBy(xpath = "//*[@id='SelectedBatch']")
	WebElement batchSelection;

	@FindBy(xpath = "//*[@id='Search']")
	WebElement search;

	@FindBy(xpath = "//*[contains(text(),'View more header information')]")
	WebElement more;

	@FindBy(xpath = "//*[@id='Reset']")
	WebElement reset;

	public void selectNetwork(String network) {
		Select oselect = new Select(selectNetwork);
		oselect.selectByValue(network);
	}

	public void selectBatch(String batch) throws InterruptedException {

		Select oselect = new Select(batchSelection);
		oselect.selectByVisibleText(batch);
	}

	public void searchAndClick(String invoiceNumber, String versionNumber)
			throws InterruptedException, AWTException, IOException {

		BasePageObject.waitForElement(20, search);
		search.click();

		BasePageObject.pause(1000);

		List<WebElement> rows = driver.findElements(By
				.xpath("//table[@class='ui-jqgrid-btable']/tbody/tr"));

		System.out.println(rows.size());
		// Thread.sleep(3000);
		for (WebElement a : rows) {
			System.out.println(a.getText());
		}

		for (int i = 2; i <= rows.size(); i++) {

			WebElement invoice = driver.findElement(By
					.xpath("//*[@id='gridSearch']/tbody/tr[" + i + "]/td[4]"));
			if (invoice.getText().equals(invoiceNumber)) {
				BasePageObject.waitForElement(20, invoice);
				System.out.println(invoice.getText());

				String version = driver.findElement(
						By.xpath("//*[@id='gridSearch']/tbody/tr[" + i
								+ "]/td[5]")).getText();
				System.out.println(version);
				if (version.equals(versionNumber)) {
					BasePageObject.entirePageScreenshot("mainpage");
					System.out.println("under if condition");
					invoice.click();
					Thread.sleep(2000);
					break;

				}

			}

		}

	}

	public void headerMatch(String... args) throws AWTException, IOException {
		BasePageObject.waitForElement(10, more);
		more.click();
		BasePageObject.entirePageScreenshot("detailspage");

		List<WebElement> header = driver.findElements(By
				.xpath("//*[contains(@id,'fullDetails')]/tbody/tr/td"));

		for (WebElement a : header) {
			System.out.print(a.getText() + " ");

		}

		List<String> allElements = new ArrayList<>();

		for (int i = 0; i < header.size(); i++) {
			allElements.add(header.get(i).getText());

		}

		for (int j = 0; j < args.length; j++) {

			s_assert.assertEquals(args[j], allElements.get(j));

		}
		driver.navigate().back();

		reset.click();
		s_assert.assertAll();

	}

}
