package org.ict.pages;

import java.io.IOException;
import java.time.Duration;

import org.ict.constants.AutomationConstants;
import org.ictkerala.excel.ExcelUtility;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ict.base.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Courses extends BaseClass
{

		
		public Courses(WebDriver driver) 
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="dropdownMenuBlocks")
		WebElement coursesmain;
		  
	    @FindBy(xpath="//h2[text()='Our Courses']")
		WebElement title;
		
		@FindBy(xpath="//input[@id='listSearch' and @placeholder='Course Name']")
		WebElement txtbox;
	    
		
		@FindBy(xpath="//button[text()=' Search ']")
		WebElement srchButton;
		
		@FindBy(xpath="//h2[@class='text-white']")  
		WebElement heading;
		
	    @FindBy(xpath="//h5[text()='No Results Found']")
		WebElement result_head;
	  
		
	
	 @FindBy(xpath="//div[@class='card__text card-body blur justify-content-center text-center mt-n5 mx-4 mb-0 border-radius-md']/h4")
	 List<WebElement> result_headings;
		
	    
	    public void show_page()
		{
			coursesmain.click();
			
		}
		
		//To display the details of a particular course 
		public void disp_single_course(String strcoursename) throws IOException 
		{
			System.out.println("COURSE SEARCH PAGE");
			driver.navigate().to(properties.getProperty("url_courses"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			txtbox.sendKeys(strcoursename);
			srchButton.click();
		}
		
		/* 
		 * Function Description : Accepts course name , if the course name matches it will return it 
		 * Else will check for 'No results found' string and return the same 
		 * */
		public String result_text(String strcoursename)
		{
			 String text=null ;
			 Boolean blMatch = false ;
			 
			for (WebElement element : result_headings) {
	             text = element.getText();
	             System.out.println( text + "  " + strcoursename );
	             if ( text.compareToIgnoreCase(strcoursename) == 0  )
	             {
	            	
	            	 blMatch = true ;
	            	 break ; 
	             }
	             
	        }
			 
			 
			
			return text;
				 
			 
		}
		
		
		 
		public String getTitle()
		{
			String strTitle = title.getText();
			return strTitle;
		} 
		
		
		
		
		
}











