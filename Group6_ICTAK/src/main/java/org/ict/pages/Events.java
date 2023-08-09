package org.ict.pages;

import java.io.IOException;

import org.ictkerala.excel.ExcelUtility;
import org.openqa.selenium.By;
//import org.ict.constants.AutomationConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ict.base.BaseClass;

public class Events extends BaseClass{



	public Events(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}



	@FindBy(xpath = "//ul[@class=\"navbar-nav navbar-nav-hover ms-auto\"]/li[5]")

	private WebElement EventsMenu;



	@FindBy(xpath = "//ul[@class=\"navbar-nav navbar-nav-hover ms-auto\"]/li[5]/ul/div/ul/li[1]/a/h6")

	private WebElement ICSETSubMenu;



	@FindBy(xpath = "//ul[@class=\"navbar-nav navbar-nav-hover ms-auto\"]/li[5]/ul/div/ul/li[2]/a/h6")

	private WebElement TechathlonSubMenu;



	public void displaySubMenu() throws InterruptedException {

		Actions act = new Actions(driver);

		act.moveToElement(EventsMenu).build().perform();

	}



	public String getICSETMenuExpectedHeading() throws IOException {

		return ExcelUtility.getData(0, 7);

	}



	public String getICSETMenuActualHeading() {

		return ICSETSubMenu.getText();

	}



	public void navigateToICSETPage() {

		ICSETSubMenu.click();

	}



	public String getICSETPageHeading() throws InterruptedException {

		driver.navigate().to(properties.getProperty("icsetpage"));

		WebElement pageHeading = driver.findElement(By.xpath("//p[@class=\"lead\"]/ancestor::div[1]/h2"));

		String actualHeading = pageHeading.getText();

		return actualHeading;

	}



	public String getTechathlonMenuExpectedHeading() throws IOException {

		return ExcelUtility.getData(1, 7);

	}



	public String getTechathlonMenuActualHeading() {

		return TechathlonSubMenu.getText();

	}



	public void navigateToTechathlonPage() {

		TechathlonSubMenu.click();

	}



	public String getTechathlonPageHeading() throws InterruptedException {

		driver.navigate().to(properties.getProperty("techathlonpage"));

		WebElement pageHeading = driver.findElement(By.xpath("//p[@class=\"lead\"]/ancestor::div[1]/h2"));

		String actualHeading = pageHeading.getText();

		return actualHeading;

	}



}