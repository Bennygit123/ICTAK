package org.ict.pages;

import java.io.IOException;
import java.nio.charset.*;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.ict.constants.AutomationConstants;
import org.ictkerala.excel.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ict.base.BaseClass;


import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;


public class Login extends BaseClass
{
	
	public Login(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	Admin_Academic admin_academic;
	
	
	@FindBy(xpath="//div[@id='navigation']/ul/li[7]/a[1]")
	//@FindBy(xpath="//div[@id='navigation']/child::ul/child::li[7]/a")
	WebElement loginBtn;
	
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement pwd;
	 
	//@FindBy(xpath="//button[text()=\' Sign in \']") 
	@FindBy(xpath="//button[text()=' Sign in ']")
	WebElement signinBtn;
	
	
	@FindBy(xpath="//h4[text()='Dashboard']")
	WebElement admin_heading;
	
	@FindBy(xpath="//h4[text()=' Welcome ']")
	WebElement heading;
	
	@FindBy(xpath="//small[text()='Password is required']")
	WebElement err_msg;
	
	
	//First set of valid credentials: superadmin & 12345
	public void verifyValidLogin_1(String pStrUserName , String pStrPassword )  throws IOException 
	{
		loginBtn.click();
		email.sendKeys(pStrUserName);
		pwd.sendKeys(pStrPassword);
		signinBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		 
	}
    
		// Explicit wait - to wait for the signin button to be click-able
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Sign in ']")));
		  
	
	
	public void invalidLogin(String pStrUserName , String pStrPassword ) throws IOException
	{
		 
		loginBtn.click();
		email.sendKeys(pStrUserName);
		pwd.sendKeys(pStrPassword);
		signinBtn.click();
	
	}   
	
	public String resultText()
		{
			String strReturn = null;
		try 
		    {
				 strReturn = admin_heading.getText() ;
	        } 
		catch (StaleElementReferenceException e) 
		   {
	       	 strReturn = admin_heading.getText() ;
	       } 
			 return  strReturn;
			
		}
	
	public String resultHead()
	{
		String strReturn = null;
	try 
	    {
			 strReturn = heading.getText() ;
        } 
	catch (StaleElementReferenceException e) 
	   {
       	 strReturn = heading.getText() ;
       } 
	System.out.println(strReturn);
		 return  strReturn;
		
	}
	
	
	public String errMsg()
	{
		String strErrMsg = null;
	try 
	    {
		strErrMsg = err_msg.getText() ;
        } 
	catch (StaleElementReferenceException e) 
	   {
		strErrMsg = err_msg.getText() ;
       } 
	System.out.println(strErrMsg);
		 return  strErrMsg;
		
	}
	
	
}

	
	 
