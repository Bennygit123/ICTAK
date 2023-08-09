package org.ict.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ict.base.BaseClass;

public class Admin_Courses extends BaseClass
{

	public Admin_Courses(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[@routerlink='/adminpage/courses']")
	WebElement admcourses;
	
	@FindBy(id="listSearch")  //Search courses text box
	WebElement searchbox;
	
	@FindBy(xpath = "//h4[text()='Courses List']" )
	WebElement title;
	
	@FindBy(xpath="//table[@class='table align-items-center mb-0']/tbody[1]/tr")
	List<WebElement> tbl_courselist;
	
	@FindBy(xpath="//div[contains(text(), 'Edit Course')]")
	WebElement head_text;
	
	//p[text()='Java Programming']  //////Heading from table data
	
	//@FindBy(partialLinkText="New Course")  
	@FindBy(xpath="//a[@routerlink='/adminpage/addcourses']")  //Button to add 'New course'
	WebElement newcourse;
	
	@FindBy(xpath="//div[text()='Add Course']")  //Title in 'Add Course' Form
	WebElement addcourse_text;
	
	public void showAdmin_Academic()
	{

		try 
	    {
			admcourses.click();
        } 
	  catch (StaleElementReferenceException e) 
	   {
		    admcourses.click();
       } 
	} 
		
	
	
	
	
	public void iterateTable(int intAction ) {
        // Get all the rows in the table
     

        // Iterate through each row
        for (WebElement row : tbl_courselist) {
            // Get all the cells in the row
             List<WebElement> cells = row.findElements(By.tagName("td"));
             // Access the last cell
             WebElement lastCell = cells.get(cells.size() - 1);
        	 WebElement linkElement;
             switch(intAction) {
             case 1:
            	 linkElement = lastCell.findElement(By.xpath("//i[@class='fas fa-eye text-info' and @title='View the Course']"));
            	 linkElement.click();
               break;
             case 2:
            	 linkElement = driver.findElement(By.xpath("//i[@class='fas fa-edit ms-3 text-warning' and @title='Edit the Course']"));
            	 linkElement.click();
                  break;
             default:
              
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
	
	
	//public void clickNewCourse() {
	 public String clickNewCourse() {

		newcourse.click();
		System.out.println("CLICKED");
		return addcourse_text.getText();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

}

