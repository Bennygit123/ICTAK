package com.ict.testcases;

import java.io.IOException;

import org.ict.constants.AutomationConstants;
import org.ict.pages.AboutCourse;
import org.ict.pages.Admin_Academic;
import org.ict.pages.Courses;
import org.ict.pages.Login;
import org.ictkerala.excel.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class Admin_AcademicTC extends BaseClass

{
	Admin_Academic admin_academic;
	Login login;
	
	@BeforeMethod
	public void admin_login() throws IOException 
	{
	
		login = new Login(driver);
		String strUserName = ExcelUtility.getData(1, 1);
		String strPassword = ExcelUtility.getData(1, 2);
		login.verifyValidLogin_1( strUserName ,  strPassword);
	}
	
	@Test
	public void admin_academic() 
	{
		admin_academic = new Admin_Academic(driver);
		admin_academic.showAdmin_Academic();
		String expTitle = admin_academic.getTitle();
		String actTitle = AutomationConstants.ADMTITLE_ACADEMIC;
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@AfterMethod
	public void tearDown()
	{
		this.driver.close();
	}
}


