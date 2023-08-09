package com.ict.testcases;

import java.io.IOException;

import org.ict.constants.AutomationConstants;
import org.ict.pages.Admin_Partnership;
import org.ict.pages.Login;
import org.ictkerala.excel.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class Admin_PartnershipTC extends BaseClass

{

	Admin_Partnership admin_partnership;

	Login login;



	@BeforeMethod

	public void admin_login() throws IOException 

	{

		admin_partnership = new Admin_Partnership(driver);

		login = new Login(driver);

		String strUserName = ExcelUtility.getData(1, 1);

		String strPassword = ExcelUtility.getData(1, 2);

		login.verifyValidLogin_1( strUserName ,  strPassword);

	}

	

	@Test(priority=1)

	public void showpartnershippage()

	{

		

		admin_partnership.showAdmin_Partnership();

		String expTitle = admin_partnership.getTitle();

		String actTitle = AutomationConstants.ADMTITLE_PARTNERSHIP;

		Assert.assertEquals(actTitle, expTitle);

	}

	@Test (priority=2)

	public void downloadpartnershiplist()

	{

		admin_partnership.showAdmin_Partnership();

		admin_partnership.downloadlist();

	}

}

