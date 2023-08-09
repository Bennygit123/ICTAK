package org.ict.pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ict.base.BaseClass;

public class Admin_Academic extends BaseClass
{

	public Admin_Academic(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//h4[text()='Academic Membership']" )
	WebElement title;
	
	@FindBy(xpath="//a[@routerlink='/adminpage/academic']")
	WebElement academicMembership;
	
	
	public void showAdmin_Academic()
	{

		try 
	    {
			academicMembership.click();
        } 
		catch (StaleElementReferenceException e) 
	    {
			academicMembership.click();
        } 
	
	} 

	
	public String getTitle()
	{
		String strTitle = title.getText();
		return strTitle;
	}
	

}
