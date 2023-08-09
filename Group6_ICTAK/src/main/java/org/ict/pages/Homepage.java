package org.ict.pages;

import java.io.IOException;

import org.ictkerala.excel.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;


import com.ict.base.BaseClass;

public class Homepage extends BaseClass

{
public Homepage(WebDriver driver)

{

this.driver=driver;

PageFactory.initElements(driver, this);

}

//home page

@FindBy(xpath="//button[@class='btn btn-white mt-4']")

private WebElement GetStarted;



//Courses page

@FindBy(id="dropdownMenuBlocks")

private WebElement Courses;



@FindBy(xpath="//a[@href=\"/LandingPage/about\"]")

private WebElement About;



//Membership page

@FindBy(id="dropdownMenuDocs")

private WebElement Memberships;



//Contact page

@FindBy(xpath="//a[@href=\"/LandingPage/contactus\"]")

private WebElement Contactus;



@FindBy(xpath = "//ul[@class=\"navbar-nav navbar-nav-hover ms-auto\"]/li[5]")

private WebElement EventsMenu;

@FindBy(xpath = "//h1[text()='Your Connection to ICTAK']")
WebElement courseheading;

@FindBy(xpath = "//ul[@class=\"navbar-nav navbar-nav-hover ms-auto\"]/li[5]/ul/div/ul/li[1]/a/h6")

private WebElement ICSETSubMenu;

@FindBy(id="dropdownMenuBlocks")
WebElement coursesmain;

@FindBy(xpath="//h2[text()='Our Courses']")
WebElement title;

@FindBy(xpath="//h1[text()='ICT Academy of Kerala']")
WebElement homepagetitle;

@FindBy(xpath="//h1[text()='ABOUT US']")
WebElement Aboutusheading;
public void homepage()

{

GetStarted.click();

}

public void Events()

{

EventsMenu.click();

}

public void Contactus()

{

Contactus.click();

}

public void Membershippage()

{

Memberships.click();

}

public void Coursespage()

{

Courses.click();

}

public void Aboutus()

{

About.click();

}

public String expectedhomepagetest() throws Exception

{

return ExcelUtility.getData(1, 8);

}



public String actualhomepagetest()

{

return GetStarted.getText();

}



public String expectedcontactpagetest() throws Exception

{

return ExcelUtility.getData(2, 8);

}



public String actualcontactpagetest()

{

return courseheading.getText();

}

public String expectedaboutpagetest() throws Exception

{

return ExcelUtility.getData(3, 8);

}



public String actualaboutpagetest()

{

return Aboutusheading.getText();

}



public void displaySubMenu() throws InterruptedException

{

Actions act = new Actions(driver);

act.moveToElement(EventsMenu).build().perform();

}



public String getExpectedSubMenuHeading() throws IOException

{

return ExcelUtility.getData(4, 8);

}



public String getActualSubMenuHeading()

{

return ICSETSubMenu.getText();

}



public void navigateToICSETPage()

{

ICSETSubMenu.click();

}



public String getICSETPageHeading() throws InterruptedException

{

driver.navigate().to(properties.getProperty("urlicset"));

WebElement pageHeading = driver.findElement(By.xpath("//p[@class=\"lead\"]/ancestor::div[1]/h2"));

String actualHeading = pageHeading.getText();

return actualHeading;

}
public void show_page()
{
coursesmain.click();

}
public String getTitle()
{
String strTitle = title.getText();
return strTitle;
}

public String getTitlehomepage()
{
String StrTitlehome = homepagetitle.getText();
return StrTitlehome;

}
}
