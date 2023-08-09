package org.ict.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ict.base.BaseClass;

public class Admin_Partnership  extends BaseClass

{

	public Admin_Partnership(WebDriver driver) 

	{

		this.driver=driver;

		PageFactory.initElements(driver, this);

	}

	

	@FindBy(xpath="//a[@class=\"nav-link text-white\" and @href=\"/adminpage/partnership\"]")

	WebElement partnership;

	

	@FindBy(xpath="//button[@class=\"btn bg-gradient-primary btn-sm mb-0\"]")

	WebElement download;

	

	@FindBy(xpath="//span[@class=\"small\"]")

	WebElement notification;

	

	@FindBy(xpath="//h4[@class=\"font-weight-bolder mb-0\"]")

	WebElement title;

	

	public void showAdmin_Partnership()

	{



		try 

	    {

			partnership.click();

        } 

	  catch (StaleElementReferenceException e) 

	   {

		    partnership.click();

       } 

	} 

	public String getTitle()

	{

		String strTitle = title.getText();

		return strTitle;

	}

	public void downloadlist()

	{

		download.click();

	}

}