package com.ict.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.ict.constants.AutomationConstants;
import org.ict.pages.AdminPatron;
import org.ict.pages.Login;
import org.ictkerala.excel.ExcelUtility;

import com.ict.base.BaseClass;

public class AdminPatronTC  extends BaseClass{
	AdminPatron adminpatron;
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

	adminpatron.showAdminPatrons();;
	String expTitle = adminpatron.getTitle();
	String actTitle = AutomationConstants.ADMTITLE_PATRONS;
	Assert.assertEquals(actTitle, expTitle);
	}


	/*
	* @Test(priority=2) public void TableIterate() { adminpatron = new
	* AdminPatron(driver); adminpatron.showAdminPatrons();;
	* adminpatron.iterateTable(2); String strReturnText = null; strReturnText =
	* adminpatron.CheckViewPageHeading(); System.out.println("View Heading " +
	* strReturnText); Assert.assertEquals(strReturnText, "Edit events"); }
	*/
	     

	@Test(priority=3)
	public void addNewEvents()
	{

	adminpatron.showAdminPatrons();;
	adminpatron.clickAddPatron();
	String strExp = adminpatron.clickAddPatron();
	System.out.println("Patrons HEADING:: " + strExp);
	Assert.assertEquals(strExp, "New patrons");
	}

	@AfterMethod
	public void tearDown()
	{
	this.driver.close();
	}

	}