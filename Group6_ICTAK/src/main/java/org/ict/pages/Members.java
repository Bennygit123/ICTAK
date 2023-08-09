package org.ict.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import com.ict.base.BaseClass;

public class Members extends BaseClass {

	

	public Members(WebDriver driver)

	{

		this.driver=driver;

		PageFactory.initElements(driver, this);

	}



	

	@FindBy(xpath="//a[text()='Memberships'] ")

	WebElement Members;

	

	@FindBy(xpath="//a[text()='Academic Membership'] ")

	WebElement Academic;



	 public void showMenuItems()

	    {

	    	Actions act = new Actions(driver);

	    	act.moveToElement(Members).build().perform();

	    }

	 
	 public void showPage()

		{

		//Events.click();

		}

	 public void showAcademic()

	 {

		//Actions act = new Actions(driver);

	    	//act.moveToElement(Icset);

	 }

	
	public void Academic() {

	Academic.click();

	}



}
