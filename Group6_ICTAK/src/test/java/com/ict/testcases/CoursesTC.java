package com.ict.testcases;

import java.io.IOException;

import org.ict.constants.AutomationConstants;
import org.ict.pages.Courses;
import org.ictkerala.excel.ExcelUtility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import com.ict.base.BaseClass;


public class CoursesTC extends BaseClass{
	Courses courses;
	
	@BeforeMethod    
	public void tearUp() throws InterruptedException
	{
		courses = new Courses(driver);
		
	}	
	
	@Test(priority=1)
	public void click_courses() throws InterruptedException
	{
		courses.show_page();
		String expTitle = courses.getTitle();
		String actTitle = AutomationConstants.COURSESTITLE;
		System.out.println(actTitle+ "Title:" +expTitle);
		Assert.assertEquals(actTitle, expTitle);
		
	}
	 
	@Test(priority=2)
	public void click_search() throws IOException, InterruptedException
	{
	
		String course_name=ExcelUtility.getData(3, 0);
		courses.disp_single_course(course_name);
		String expResult =courses.result_text(course_name);
		//System.out.println("Heading:"  + expResult);
		Assert.assertEquals(expResult.toUpperCase(),course_name.toUpperCase());
	}
	
	@AfterMethod
	public void tearDown()
	{
		this.driver.close();
	}

}