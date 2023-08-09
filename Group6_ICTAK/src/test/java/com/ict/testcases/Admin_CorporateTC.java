package com.ict.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
import org.ict.constants.AutomationConstants;
import org.ict.pages.Admin_Academic;
import org.ict.pages.Admin_Corporate;
import org.ict.pages.Courses;
import org.ict.pages.Login;
import org.ictkerala.excel.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class Admin_CorporateTC  extends BaseClass
{
	Login login;
	Admin_Corporate admin_corporate;
	
	@BeforeMethod
	public void admin_login() throws IOException 
	{
		admin_corporate = new Admin_Corporate(driver);
		
		login = new Login(driver);
		String strUserName = ExcelUtility.getData(1, 1);
		String strPassword = ExcelUtility.getData(1, 2);
		
		System.out.println(strUserName + " Pwd " + strPassword );
		login.verifyValidLogin_1( strUserName ,  strPassword);
	}
	
	@Test(priority=1)
	public void admin_corporate() 
	{
		//admin_corporate = new Admin_Corporate(driver);
		admin_corporate.showAdminCorporate(); 
		String expTitle = admin_corporate.getTitle();
		String actTitle = AutomationConstants.ADMTITLE_CORP;
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@Test(priority=2)
	public void tbl_iterate()
	{
		
		admin_corporate.showAdminCorporate(); 
		admin_corporate.iterateTbl(1);
		String strReturnText = null;
		strReturnText = admin_corporate.CheckViewPageHeading();
		System.out.println("View Heading " + strReturnText);
		Assert.assertEquals(strReturnText, AutomationConstants.ADM_CORP_DEL);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		this.driver.close();
	}
	
}