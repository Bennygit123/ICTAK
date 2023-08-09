package com.ict.testcases;


import java.io.IOException;
import java.time.Duration;

import org.ict.constants.AutomationConstants;
import org.ict.pages.Homepage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class HomepageTC extends BaseClass

{



	Homepage homepagetc;

	@BeforeMethod

	public void init()

	{

	homepagetc= new Homepage(driver);

	}

	@Test(priority = 1)

	public void homepagedisplay() throws Throwable

	{

	homepagetc.homepage();

	String expTitle = homepagetc.getTitlehomepage();

	String actTitle = AutomationConstants.HOMEPAGE;

	System.out.println(actTitle+ "Title:" +expTitle);

	Assert.assertEquals(actTitle, expTitle);

	    }

	@Test(priority = 2)

	public void contactpagedisplay() throws Throwable

	{

	homepagetc.Contactus();

	String expectedResult = homepagetc.expectedcontactpagetest();

	String actualResult = homepagetc.actualcontactpagetest();

	Assert.assertEquals(actualResult, expectedResult);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	 }

	@Test(priority = 3)

	public void aboutusdisplay() throws Throwable

	{

	homepagetc.Aboutus();

	String expectedResult = homepagetc.expectedaboutpagetest();

	String actualResult = homepagetc.actualaboutpagetest();

	Assert.assertEquals(actualResult, expectedResult);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	    }

	@Test(priority = 4)

	public void displayEventSubMenu() throws IOException, InterruptedException {

	homepagetc.displaySubMenu();

	String expectedResult = homepagetc.getExpectedSubMenuHeading();

	String actualResult = homepagetc.getActualSubMenuHeading();

	Assert.assertEquals(actualResult, expectedResult);

	}

	

	@Test(priority = 5)

	public void displayICSETPage() throws IOException, InterruptedException {

	homepagetc.navigateToICSETPage();

	String expectedResult = homepagetc.getExpectedSubMenuHeading();

	String actualResult = homepagetc.getICSETPageHeading();

	Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority=6)

	public void click_courses() throws InterruptedException

	{

		homepagetc.show_page();

		String expTitle = homepagetc.getTitle();

		String actTitle = AutomationConstants.COURSESTITLE;

		System.out.println(actTitle+ "Title:" +expTitle);

		Assert.assertEquals(actTitle, expTitle);

	}

	@AfterMethod

	public void tearDown()

	{

		this.driver.close();

	}

}

