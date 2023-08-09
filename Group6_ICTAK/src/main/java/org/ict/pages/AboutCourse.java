package org.ict.pages;

import java.io.IOException;

import org.ictkerala.excel.ExcelUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ict.base.BaseClass;

public class AboutCourse extends BaseClass 
{

		public AboutCourse(WebDriver driver) 
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
		@FindBy(name="name")
		WebElement name;
		
		@FindBy(xpath="//input[@name='email' and @placeholder='Email']")
		WebElement email;
		
		@FindBy(xpath="//input[@placeholder ='Number' and @name='phoneno']")
		WebElement phnum;
		
		@FindBy(xpath="//button[text()='Register']")
		WebElement registerBtn;
		
		@FindBy(xpath="//button[text()=' Apply Now ']")
		WebElement applyBtn;
		
		@FindBy(id="dropdownMenuBlocks")
		WebElement coursesmain;
		
		@FindBy(xpath="//span[@class='text-sm'][1]")
		WebElement dropdown;
		
		
	
		public void show_menu_page() throws IOException
	    {
	    	Actions act = new Actions(driver);
	    	act.moveToElement(coursesmain).perform();
	    	//act.moveToElement(coursesmain).click(dropdown).perform();
	         dropdown.click();
	        	
	    }
			
		public String show_reg_form(String strName, String strEmail, String strPhone) throws IOException, InterruptedException
		{
			driver.navigate().to(properties.getProperty("url_single"));
			applyBtn.click();
			
			name.sendKeys(strName);
			email.sendKeys(strEmail);
			phnum.sendKeys(strPhone);
			registerBtn.click();
			
			
			Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();            
			return alertText;
		}
		
		
		
	
}