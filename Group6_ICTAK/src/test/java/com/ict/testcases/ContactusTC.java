package com.ict.testcases;

import java.io.IOException;

import org.ict.pages.AboutCourse;
import org.ict.pages.Contactus;
import org.ictkerala.excel.ExcelUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class ContactusTC extends BaseClass

{

	Contactus contactform;
	
	@BeforeMethod    
	public void click_courses() throws InterruptedException
	{
		
		contactform = new Contactus(driver);
		
	}
	
	@Test(priority = 1)
	public void contactuspagecall()
	{
	
	contactform.Contactuspageload();
	}
	
	@Test(priority = 2)
	public void contactformfill() throws IOException, InterruptedException
	{
	String name = ExcelUtility.getData(5, 8);
	String emailfield = ExcelUtility.getData(6, 8);
	String lookingfield = ExcelUtility.getData(7, 8);
	String yourmessage = ExcelUtility.getData(8, 8);
	contactform.setName(name);
	contactform.setemail(emailfield);
	contactform.setlookingfor(lookingfield);
	contactform.setmessage(yourmessage);
	Thread.sleep(2000);
	contactform.sendmessage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		this.driver.close();
	}

}
