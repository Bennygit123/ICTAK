package com.ict.testcases;

import java.io.IOException;
import java.time.Duration;

import org.ict.pages.AboutCourse;
import org.ict.pages.Login;
import org.ict.pages.Members;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ict.base.BaseClass;

public class MembershipsTC extends BaseClass{

Members members;
@BeforeMethod    
public void tearUp() throws InterruptedException
{
	
	members = new Members(driver);
	
}

@Test(priority=1)
public void showMenu()
{
//members = new Members(driver);
members.showMenuItems();

}

@Test(priority=2)
public void clickMembers()
{
//members = new Members(driver);
members.showPage();

}


@Test(priority=3)
public void showpageAcademic()
{
//members = new Members(driver);
members.showAcademic();

}

@Test(priority=4)
public void Academic()
{
//members = new Members(driver);
members.Academic();

}

/*@Test(priority=5)
public void Apply()
{
events = new Events(driver);
events.Apply();
}*/
@AfterMethod
public void tearDown()
{
	this.driver.close();
}

}
