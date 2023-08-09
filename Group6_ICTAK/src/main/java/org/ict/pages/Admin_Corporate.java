package org.ict.pages;

import java.io.IOException;
import org.openqa.selenium.Alert;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ict.base.BaseClass;

public class Admin_Corporate extends BaseClass
{
	
	public Admin_Corporate(WebDriver driver) 

	{

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}



	@FindBy(xpath = "//h4[text()='Corporate Membership']" )
	WebElement title;

	@FindBy(xpath="//a[@routerlink='/adminpage/corporate']")
	WebElement corporateMembership;
	
	@FindBy(xpath="//table[@id='excel-table']/tbody[1]/tr") 
	List<WebElement> tbl_corplist;
	
	@FindBy(id="swal2-html-container")  //Alert box: You won't be able to revert this!
	WebElement head_text;
	
	@FindBy(xpath="//button[text()='Yes, Delete it!']")  //Delete button in alert box
	WebElement delBtn;

	@FindBy(xpath="//button[text()='No, Cancel please!']")  //Cancel  button in alert box
	WebElement cancelBtn; 
	
	
	
	public void showAdminCorporate()

	{
	
		try 

	    {
			corporateMembership.click();	
	    } 

	    catch (StaleElementReferenceException e) 

	    {
		  corporateMembership.click();	

	    } 

	}
	
	
	
	public void iterateTbl(int intAction ) {
        // Get all the rows in the table
     

        // Iterate through each row
        for (WebElement row : tbl_corplist) {
            // Get all the cells in the row
             List<WebElement> cells = row.findElements(By.tagName("td"));
             // Access the last cell
             WebElement lastCell = cells.get(cells.size() - 1);
        	 WebElement linkElement;
             switch(intAction) {
             case 1:
            	 linkElement = lastCell.findElement(By.xpath("//i[@class='fas fa-trash ms-3 text-danger' and @title='Delete the corporate member']"));
            	 linkElement.click();
               break;
            
              
           }
         }
    
    }
	 
	
	public String CheckViewPageHeading()
	{
		return head_text.getText();
	}
	
	public String getTitle()
	{
		String strTitle = title.getText();
		return strTitle;
	}
	
	/*
	  Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept(); 
            //alert.dismis();    //To cancel       
			return alertText;
   */
	
	
	
}
