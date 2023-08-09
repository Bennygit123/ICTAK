package com.ict.testcases;

import java.io.IOException;
import java.time.Duration;

import org.ict.pages.ICSETEvent;
import org.ictkerala.excel.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;



public class ICSETEventsTC extends BaseClass {



	ICSETEvent icsetpage;



	@AfterClass

	void disposeDriver() {

		driver.close();

	}



	@Test(priority = 1)

	public void displayRegisterWindow() throws IOException {

		icsetpage = new ICSETEvent(driver);

		icsetpage.clickApplyButton();



		String expectedResult = icsetpage.getExpectedRegisterButtonText();

		String actualResult = icsetpage.getActualRegisterButtonText();

		Assert.assertEquals(actualResult, expectedResult);



	}



	@Test(priority = 2)

	public void verifySuccessfullRegistration() throws IOException {

		icsetpage.setRegisterFields();

		icsetpage.clickRegisterButton();



		String expectedResult = icsetpage.getExpectedAlertBoxText();

		String actualResult = icsetpage.getActualAlertBoxText();

		Assert.assertEquals(actualResult, expectedResult);



	}

	@AfterMethod
	public void tearDown()
	{
		this.driver.close();
	}

}