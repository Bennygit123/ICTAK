package org.ict.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ict.base.BaseClass;

public class AdminEvents extends BaseClass 

{



	public AdminEvents(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}



	@FindBy(xpath = "//a[@routerlink='/adminpage/events']")

	WebElement admevents;



	@FindBy(id = "listSearch")

	WebElement eventsearchbox;



	@FindBy(xpath = "//table[@class='table align-items-center mb-0']/tbody[1]/tr")

	List<WebElement> tbl_eventlist;



	@FindBy(xpath = "//h4[text()='Events list'")

	WebElement title;



	@FindBy(xpath = "//div[contains(text(), 'Edit Event')]")

	WebElement head_text;



	@FindBy(xpath = "//a[@routerlink='/adminpage/add-events']")

	WebElement newevents;



	@FindBy(xpath = "//div[text()='Add events']")

	WebElement addevents_text;



	public void showAdminEvents() {



		try {

			admevents.click();

		} catch (org.openqa.selenium.StaleElementReferenceException e) {

			admevents.click();

		}

	}



	public void iterateTable(int intAction) {

		// Get all the rows in the table



		// Iterate through each row

		for (WebElement row : tbl_eventlist) {

			// Get all the cells in the row

			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Access the last cell

			WebElement lastCell = cells.get(cells.size() - 1);

			WebElement linkElement;

			switch (intAction) {

			case 1:

				linkElement = lastCell

						.findElement(By.xpath("//i[@class='fas fa-eye text-info' and @title='View the Course']"));

				linkElement.click();

				break;

			case 2:

				linkElement = driver.findElement(

						By.xpath("//i[@class='fas fa-edit ms-3 text-warning' and @title='Edit the Course']"));

				linkElement.click();

				break;

			default:

				// code block

			}

		}



	}



	public String CheckViewPageHeading() {

		return head_text.getText();

	}



	public String getTitle() {

		String strTitle = title.getText();

		return strTitle;

	}



	// public void clickNewCourse() {

	public String clickNewEvent() {



		newevents.click();

		System.out.println("CLICKED");

		return addevents_text.getText();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



	}

}

