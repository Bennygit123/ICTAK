package org.ict.pages;
import java.util.List;
import com.ict.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminStaffs extends BaseClass {
	public AdminStaffs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//a[@routerlink='/adminpage/staffs']")
		WebElement admstaffs;

		@FindBy(id = "listSearch")
		WebElement staffsearchbox;

		@FindBy(xpath = "//table[@class='table align-items-center mb-0']/tbody[1]/tr")
		List<WebElement> tbl_stafflist;

		@FindBy(xpath = "//h4[text()='Staff List']")
		WebElement title;

		@FindBy(xpath = "//div[contains(text(), 'Edit Staff')]")
		WebElement head_text;

		@FindBy(xpath = "//a[@routerlink='/adminpage/add-staffs']")
		WebElement newstaffs;

		@FindBy(xpath = "//div[text()='New Staff']")
		WebElement newstaffs_text;

		public void showAdminStaffs() {

		try {
		admstaffs.click();
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
		admstaffs.click();
		}
		}

		public void iterateTable(int intAction) {
		// Get all the rows in the table

		// Iterate through each row
		for (WebElement row : tbl_stafflist) {
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
		public String clickAddStaff() {

		newstaffs.click();
		System.out.println("CLICKED");
		return newstaffs_text.getText();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		}

		}
