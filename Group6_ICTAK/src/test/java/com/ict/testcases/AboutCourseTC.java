package com.ict.testcases;

import java.io.IOException;

import org.ict.constants.AutomationConstants;
import org.ict.pages.AboutCourse;
import org.ict.pages.Courses;
import org.ict.pages.Login;
import org.ictkerala.excel.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class AboutCourseTC extends BaseClass{
	
	AboutCourse aboutcourse;
	
	@BeforeMethod    
	public void tearUp() throws InterruptedException
	{
		
		aboutcourse = new AboutCourse(driver);
		
	}
	
	@Test(priority=1)
	public void sub_menu() throws IOException
	{
		
		aboutcourse.show_menu_page();
	}
	
	
	@Test(priority=2)
	public void showform() throws IOException, Throwable
	{
		
		String name = ExcelUtility.getData(1, 3) ;
		String email =  ExcelUtility.getData(2, 3) ;
		String phnum  =   ExcelUtility.getData(3, 3);
		

		String expResult = aboutcourse.show_reg_form(name,email,phnum);
		System.out.println(expResult ); 
		
		Assert.assertEquals(expResult, "Registration Successfull");
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		this.driver.close();
	}
}