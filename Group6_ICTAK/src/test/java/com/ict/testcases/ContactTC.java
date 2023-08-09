package com.ict.testcases;

import org.ict.pages.Contactus;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

import org.ictkerala.excel.ExcelUtility;

public class ContactTC extends BaseClass

{

	Contactus contactform;

	@Test(priority = 1)

	public void contactuspagecall()

	{

		contactform = new Contactus(driver);

		contactform.Contactuspageload();

	}

	 

	@Test(priority = 2)

	public void contactformfill() throws Exception

	{

		String name = ExcelUtility.getData(5, 8);

		String emailfield = ExcelUtility.getData(6, 8);

		String lookingfield = ExcelUtility.getData(7, 8);	

		String yourmessage = ExcelUtility.getData(8, 8);

		contactform.setName(name);

		contactform.setemail(emailfield);

		contactform.setlookingfor(lookingfield);

		contactform.setmessage(yourmessage);

		contactform.sendmessage();

		String expectedResult = contactform.expectedcontactus();

		String actualResult = contactform.actualcontactus();

		Assert.assertEquals(actualResult, expectedResult);

	}

}


