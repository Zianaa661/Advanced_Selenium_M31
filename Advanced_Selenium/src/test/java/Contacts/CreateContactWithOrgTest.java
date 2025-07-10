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
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.CreateOrganizationPage;
import Pom_Repo.Homepage;
import Pom_Repo.LoginPage;
import Pom_Repo.OrganizationLookUpImg;
import Pom_Repo.ValidateContactPage;
import Pom_Repo.ValidateOrgPage;
import Pom_Repo.WindowSwitchOrg;
import Pom_Repo.WindowSwitchingPage;

public class CreateContactWithOrgTest extends BaseClass {
	@Test
	public void CreateContactWithOrgTest() throws Throwable {
		Homepage home = new Homepage(driver);
		WebDriver_Utility wlib = new WebDriver_Utility();
// click on organizations link->
		home.clickOrganization();
// -------------------------------------------------------------------------------------------

		// click on create organization lookup image->
		OrganizationLookUpImg lookup = new OrganizationLookUpImg(driver);
		lookup.clicklookUpImg();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandom();
		// -------------------------------------------------------------------------------------------
		Excel_Utility data = new Excel_Utility();
		String OrgName = data.getExcel("Organization", 0, 0) + ranNum;
		String phNumb = data.getExcelDataUsingFormatter("Organization", 1, 0);
		String mailID = data.getExcelDataUsingFormatter("Organization", 2, 0);
		CreateOrganizationPage fillOrg = new CreateOrganizationPage(driver);
		fillOrg.enterOrgnaizationData(OrgName, mailID, phNumb);
		// -------------------------------------------------------------------------------------------
		// verify whether the organization is created in Organization Information page
		ValidateOrgPage validate = new ValidateOrgPage(driver);
		validate.validateOrg(driver, OrgName);
// -------------------------------------------------------------------------------------------
		home.clickcontact();
// click on create Contact lookup image->
		ContactLookUpImgPage lookUp = new ContactLookUpImgPage(driver);
		lookUp.clicklookUpImg();
		String fName = data.getExcel("Contact", 0, 0);
		String lName = data.getExcel("Contact", 1, 0);
		CreateContactPage con = new CreateContactPage(driver);
		con.selectDropDown(driver);
		con.enterContactData(fName, lName);
		WindowSwitchOrg win = new WindowSwitchOrg(driver);
		win.clickOrgLookUp();
//window switching 
		wlib.windowSwitching(driver, "Accounts&action");
// -------------------------------------------------------------------------------------------
//searching org in the child window
		win.enterOrgDetails(OrgName);
		win.enterOrgNameInCont(driver, OrgName);
		// switching back to main page
		wlib.windowSwitching(driver, "Contacts&action");
		// saving the contact form
		con.clickSaveButton();
		ValidateContactPage validate2 = new ValidateContactPage(driver);
		validate2.validateContactFirstNAme(driver, fName);
		validate2.validateContactlastNAme(driver, lName);

	}
}
