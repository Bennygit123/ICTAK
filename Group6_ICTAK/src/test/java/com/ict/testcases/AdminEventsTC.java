package com.ict.testcases;

import java.io.IOException;

import org.ict.constants.AutomationConstants;
import org.ict.pages.AdminEvents;
import org.ict.pages.Login;
import org.ictkerala.excel.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class AdminEventsTC  extends BaseClass{

	AdminEvents adminevents;

	Login login;



	@BeforeMethod

	public void admin_login() throws IOException 

	{

	

		login = new Login(driver);

		String strUserName = ExcelUtility.getData(1, 1);

		String strPassword = ExcelUtility.getData(1, 2);

		login.verifyValidLogin_1( strUserName ,  strPassword);

	}

	



	@Test(priority=1)

	public void showPage()

	{

		

		adminevents.showAdminEvents();

		String expTitle = adminevents.getTitle();

		String actTitle = AutomationConstants.ADMTITLE_EVENTS;

		Assert.assertEquals(actTitle, expTitle);

	}

	



	@Test(priority=2)

	public void TableIterate()

	{

		adminevents = new AdminEvents(driver);

		adminevents.showAdminEvents();

		adminevents.iterateTable(2);

		String strReturnText = null;

		strReturnText = adminevents.CheckViewPageHeading();

		System.out.println("View Heading " + strReturnText);

		Assert.assertEquals(strReturnText, "Edit events");

	}

     

	

	@Test(priority=3)

	public void addNewEvents()

	{

		

		adminevents.showAdminEvents();

		adminevents.clickNewEvent();

		String strExp = adminevents.clickNewEvent();

		System.out.println("Events HEADING:: " + strExp);

		Assert.assertEquals(strExp, "Add Events");

	}

	

	@AfterMethod

	public void tearDown()

	{

		this.driver.close();

	}



}