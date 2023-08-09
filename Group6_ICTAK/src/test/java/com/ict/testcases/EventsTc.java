package com.ict.testcases;
//import com.ict.pages.Events;
//import com.qa.pages.ICSETEvent;

import java.io.IOException;
import java.time.Duration;

import org.ict.pages.Events;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class EventsTc extends BaseClass  {



	Events eventsMenu;



	@BeforeMethod

	void initializeConfigurations() {

		eventsMenu = new Events(driver);

	}



	@AfterClass

	void disposeDriver() {

		driver.close();

	}



	private void displayDropdownMenu() throws InterruptedException {

		eventsMenu.displaySubMenu();

	}



	@Test(priority = 1)

	public void displayICSETSubMenu() throws IOException, InterruptedException {

		displayDropdownMenu();



		String expectedResult = eventsMenu.getICSETMenuExpectedHeading();

		String actualResult = eventsMenu.getICSETMenuActualHeading();

		Assert.assertEquals(actualResult, expectedResult);

	}



	@Test(priority = 2)

	public void displayICSETPage() throws IOException, InterruptedException {

		displayDropdownMenu();



		eventsMenu.navigateToICSETPage();

		String expectedResult = eventsMenu.getICSETMenuExpectedHeading();

		String actualResult = eventsMenu.getICSETPageHeading();

		Assert.assertEquals(actualResult, expectedResult);

	}



	@Test(priority = 3)

	public void displayTechathlonSubMenu() throws IOException, InterruptedException {

		displayDropdownMenu();



		String expectedResult = eventsMenu.getTechathlonMenuExpectedHeading();

		String actualResult = eventsMenu.getTechathlonMenuActualHeading();

		Assert.assertEquals(actualResult, expectedResult);



	}



	@Test(priority = 4)

	public void displayTechathlonPage() throws IOException, InterruptedException {

		displayDropdownMenu();



		eventsMenu.navigateToTechathlonPage();

		String expectedResult = eventsMenu.getTechathlonMenuExpectedHeading();

		String actualResult = eventsMenu.getTechathlonPageHeading();

		Assert.assertEquals(actualResult, expectedResult);



	}

	@AfterMethod
	public void tearDown()
	{
		this.driver.close();
	}

}

