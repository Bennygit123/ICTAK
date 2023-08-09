package org.ict.pages;
import java.util.List;

import com.ict.base.BaseClass;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
public class AdminPatron extends BaseClass{



	public AdminPatron(WebDriver driver) 

	{

		this.driver=driver;

		PageFactory.initElements(driver, this);

	}

	

	@FindBy(xpath="//a[@routerlink='/adminpage/patrons']")

	WebElement admpatrons;	

	

	@FindBy(xpath = "//h4[text()='Patrons List']" )

	WebElement title;

	

	@FindBy(xpath="//table[@class='table align-items-center mb-0']/tbody[1]/tr")			

	List<WebElement> tbl_patronlist;

	

	@FindBy(xpath = "//a[@routerlink='/adminpage/addpatron']" )

	WebElement addpatron;

	

	@FindBy(xpath = "//h2[text()=\'New patrons\']" )

	WebElement addpatron_text;

	

	@FindBy(id = "listSearch")

	WebElement patronsearchbox;	



	

	

	public void showAdminPatrons()

	{



		try 

	    {

			admpatrons.click();

        } 

		catch (org.openqa.selenium.StaleElementReferenceException e)

	   {

		  admpatrons.click();

       } 

	} 

		

	

	

	

	

	public void iterateTable(int intAction ) {

        // Get all the rows in the table

     



        // Iterate through each row

        for (WebElement row : tbl_patronlist) {

            // Get all the cells in the row

             List<WebElement> cells = row.findElements(By.tagName("td"));

             // Access the last cell

             WebElement lastCell = cells.get(cells.size() - 1);

        	 WebElement linkElement;

             switch(intAction) {

             case 1:

            	 linkElement = lastCell.findElement(By.xpath("//i[@class='fas fa-eye text-info' and @title='View the patrons']"));

            	 linkElement.click();

               break;

             default:

              

           }

         }

    

    }	

	

	

	public String getTitle()

	{

		String strTitle = title.getText();

		return strTitle;

	}

	

	

	//public void clickNewCourse() {

	 public String clickAddPatron() {



		addpatron.click();

		System.out.println("CLICKED");

		return addpatron_text.getText();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



	}

}



