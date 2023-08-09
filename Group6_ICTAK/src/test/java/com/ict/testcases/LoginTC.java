package com.ict.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
import org.ict.constants.AutomationConstants;
import org.ict.pages.Login;

import org.ictkerala.excel.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ict.base.BaseClass;



public class LoginTC extends BaseClass{
	  
		Login loginpg;
	
		@BeforeMethod
		public void tearUp()
		{
			loginpg = new Login(driver);
			
		}
		
		
		@Test(priority=1)
		public void validCredentials() throws IOException
		{
			String strUserName = ExcelUtility.getData(1, 1);
			String strPassword = ExcelUtility.getData(1, 2);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			loginpg.verifyValidLogin_1(strUserName,strPassword);
			String expTitle = loginpg.resultText();
			System.out.println(expTitle + " " + AutomationConstants.ADMTITLE );
			Assert.assertEquals(expTitle,AutomationConstants.ADMTITLE);
		
		}
	
		
		
		@Test(priority=2)
		public void invalidCredentials() throws IOException
		{
			
			String strUserName = ExcelUtility.getData(2, 1);
			String strPassword = "";
			loginpg.invalidLogin(strUserName,strPassword);
			String expTitle = loginpg.errMsg();
			System.out.println("Error msg:" +expTitle);
			Assert.assertEquals(expTitle,"Password is required");
		}
		
		
		/*
		@Test(priority=3)
		public void verify_2() throws IOException 
		{
			    String strUserNameInv = ExcelUtility.getData(3, 1);
				String strPasswordInv = ExcelUtility.getData(3, 2);
				System.out.println(strUserNameInv + " " + strPasswordInv );
				loginpg.verifyValidLogin_1(strUserNameInv,strPasswordInv);
				String expTitle = loginpg.resultText();
				Assert.assertEquals(expTitle,"Dashboard");
		
		}
		 */

		@AfterMethod
		public void tearDown()
		{
			//this.driver.close();
		}
	}

