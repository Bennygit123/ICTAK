package com.ict.testcases;

import java.io.IOException;

import org.ict.constants.AutomationConstants;
import org.ict.pages.AboutCourse;
import org.ict.pages.Admin_Academic;
import org.ict.pages.Admin_Courses;
import org.ict.pages.Courses;
import org.ict.pages.Login;
import org.ictkerala.excel.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class Admin_CoursesTC extends BaseClass{
	

	Admin_Courses admin_courses;
	Login login;

	@BeforeMethod
	public void admin_login() throws IOException 
	{
		admin_courses = new Admin_Courses(driver);
		
		login = new Login(driver);
		String strUserName = ExcelUtility.getData(1, 1);
		String strPassword = ExcelUtility.getData(1, 2);
		login.verifyValidLogin_1( strUserName ,  strPassword);
	}
	
	@Test(priority=1)
	public void showPage()
	{
		
		admin_courses.showAdmin_Academic();
		String expTitle = admin_courses.getTitle();
		String actTitle = AutomationConstants.ADMTITLE_COURSES;
		Assert.assertEquals(actTitle, expTitle);
	}

	@Test(priority=2)
	public void table_iterate()
	{
		
		admin_courses.showAdmin_Academic();
		admin_courses.iterateTable(2);
		String strReturnText = null;
		strReturnText = admin_courses.CheckViewPageHeading();
		System.out.println("View Heading " + strReturnText);
		Assert.assertEquals(strReturnText, "Edit Course");
	}
	
	@Test(priority=3)
	public void addNewCourse()
	{
		
		admin_courses.showAdmin_Academic();
		admin_courses.clickNewCourse();
		String strExp = admin_courses.clickNewCourse();
		System.out.println("COURSE HEADING:: " + strExp);
		Assert.assertEquals(strExp, "Add Course");
	}
	
	@AfterMethod
	public void tearDown()
	{
		this.driver.close();
	}
	
}