package Contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.Homepage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidateContactPage;
//@Listeners(Generic_Utilities.ListenerImplem.class)
public class CreateContactTest extends BaseClass {
	// WebDriver driver;
//	@Test(groups="regressionTest")
	@Test(retryAnalyzer = Generic_Utilities.RetryAnalyserImp.class)
	public void CreateContactTest() throws Throwable {
		// Step1: Login to vtiger application
// step2: click on Contact link
		Homepage home = new Homepage(driver);
		home.clickcontact();
		// -------------------------------------------------------------------------------------------
// click on create Contact lookup image->
		ContactLookUpImgPage lookUp = new ContactLookUpImgPage(driver);
		lookUp.clicklookUpImg();
		Excel_Utility data = new Excel_Utility();
		String fName = data.getExcel("Contact", 0, 0);

		String lName = data.getExcel("Contact", 1, 0);
		CreateContactPage con = new CreateContactPage(driver);
		con.selectDropDown(driver);
		//Assert.fail("-----------------FAILING-------------------");
		con.enterContactData(fName, lName);
		con.clickSaveButton();
		// -------------------------------------------------------------------------------------------
		
		ValidateContactPage validate = new ValidateContactPage(driver);
		//Assert.fail("-----------------FAILING-------------------");
		validate.validateContactFirstNAme(driver, fName);
		validate.validateContactlastNAme(driver, lName);

	}

}
