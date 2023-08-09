package org.ict.pages;
import java.io.IOException;
import java.time.Duration;

import org.ictkerala.excel.ExcelUtility;
import org.openqa.selenium.Alert;
//import com.qa.pages.Events;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ict.base.BaseClass;

public class ICSETEvent extends BaseClass {



	public ICSETEvent(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		driver.navigate().to(properties.getProperty("icsetpage"));

	}



	@FindBy(xpath = "//button[@class=\"btn bg-gradient-success w-auto me-2 mt-4\"]")

	private WebElement applyButton;



	@FindBy(xpath = "//input[@name=\"name\" and @placeholder=\"Name\"]")

	private WebElement icseteventname;



	@FindBy(xpath = "//input[@name=\"email\" and @placeholder=\"Email\"]")

	private WebElement icseteventemail;



	@FindBy(xpath = "//input[@name=\"phoneno\" and @placeholder=\"Number\"]")

	private WebElement icseteventphoneno;



	@FindBy(xpath = "//button[text()='Register']")

	private WebElement registerButton;



	public void clickApplyButton() {

		applyButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}



	public void setRegisterFields() throws IOException {

		String name = ExcelUtility.getData(6, 7);

		String email = ExcelUtility.getData(7, 7);

		String phoneno = ExcelUtility.getData(8, 7);

		icseteventname.sendKeys(name);

		icseteventemail.sendKeys(email);

		icseteventphoneno.sendKeys(phoneno);

	}



	public void clickRegisterButton() {

		registerButton.click();



	}



	public String getExpectedRegisterButtonText() throws IOException {

		return ExcelUtility.getData(11, 7);

	}



	public String getActualRegisterButtonText() {

		return registerButton.getText();

	}



	public String getExpectedAlertBoxText() throws IOException {

		return ExcelUtility.getData(12, 7);

	}



	public String getActualAlertBoxText() {

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();

		alert.accept();

		return alertText;

	}



}