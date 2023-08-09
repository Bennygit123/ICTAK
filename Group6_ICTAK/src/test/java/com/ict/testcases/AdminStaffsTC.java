package com.ict.testcases;
import java.io.IOException;



import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import org.ict.constants.AutomationConstants;

import org.ict.pages.AdminStaffs;

import org.ict.pages.Login;

import org.ictkerala.excel.ExcelUtility;



import com.ict.base.BaseClass;
public class AdminStaffsTC extends BaseClass {

	AdminStaffs adminstaffs;

	Login login;



	@BeforeMethod

	public void admin_login() throws IOException {


		
		login = new Login(driver);

		String strUserName = ExcelUtility.getData(1, 1);

		String strPassword = ExcelUtility.getData(1, 2);

		login.verifyValidLogin_1(strUserName, strPassword);

	}



	@Test(priority = 1)

	public void showPage() {



		adminstaffs.showAdminStaffs();

		String expTitle = adminstaffs.getTitle();

		String actTitle = AutomationConstants.ADMTITLE_STAFFS;

		Assert.assertEquals(actTitle, expTitle);

	}



	@Test(priority = 2)

	public void TableIterate() {

		adminstaffs = new AdminStaffs(driver);

		adminstaffs.showAdminStaffs();

		adminstaffs.iterateTable(2);

		String strReturnText = null;

		strReturnText = adminstaffs.CheckViewPageHeading();

		System.out.println("View Heading " + strReturnText);

		Assert.assertEquals(strReturnText, "Edit Staff");

	}



	@Test(priority = 3)

	public void addNewStaffs() {



		adminstaffs.showAdminStaffs();

		adminstaffs.clickAddStaff();

		String strExp = adminstaffs.clickAddStaff();

		System.out.println("Staff HEADING:: " + strExp);

		Assert.assertEquals(strExp, "New Staff");

	}



	@AfterMethod

	public void tearDown() {

		this.driver.close();

	}

}


