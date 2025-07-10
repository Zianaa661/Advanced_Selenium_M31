package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class CreateContactPage {

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement fname;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lname;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	
	

	public WebElement getFname() {
		return fname;
	}



	public WebElement getLname() {
		return lname;
	}



	public WebElement getSaveButton() {
		return saveButton;
	}

	public void enterContactData(String fName, String lName) {
		fname.sendKeys(fName);
		lname.sendKeys(lName);


	}
	public void clickSaveButton() {
		saveButton.click();
	}

	public void selectDropDown(WebDriver driver) {
		WebElement dop = driver.findElement(By.xpath("//select[@name='salutationtype']"));

		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.dropDown(dop, 1);
	}
}
