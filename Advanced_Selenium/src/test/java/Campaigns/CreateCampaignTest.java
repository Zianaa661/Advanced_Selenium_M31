package Campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CamLookUpImgPage;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateCampaignPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.Homepage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidateContactPage;
import Pom_Repo.ValidationCampaignPage;

//@Listeners(Generic_Utilities.ListenerImplem.class)
public class CreateCampaignTest extends BaseClass {

	@Test(groups = "smmokeTest")

	public void CreateCampaignTest() throws Throwable {

		// -------------------------------------------------------------------------------------------
		// mouseOverOn more Link->
		// click on campaigns->
		Homepage home = new Homepage(driver);
		home.clickCampaign();
		// -------------------------------------------------------------------------------------------
		// click on create campaign lookup image->
		CamLookUpImgPage CamLookUp = new CamLookUpImgPage(driver);
		CamLookUp.clicklookUpImg();
		// -------------------------------------------------------------------------------------------
		// avoid Duplicates
		Java_Utility jlib = new Java_Utility();
		int ran = jlib.getRandom();
		// Enter campaignName->
		Excel_Utility excelData = new Excel_Utility();
		String CamName = excelData.getExcel("Campaign", 0, 0) + ran;
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.enterCampName(CamName);
		campPage.clickSaveButton();
		//Assert.fail("I am failing the script");
		// Validation of data typed and saved
		ValidationCampaignPage validate = new ValidationCampaignPage(driver);
		validate.validateCamp(driver, CamName);

	}
}
//-------------------To test @Test(groups="regressionTest") below code written & commented---------------------------------
//@Test(groups="regressionTest")
//public void CreateContactTest() throws Throwable {
//	// Step1: Login to vtiger application
////step2: click on Contact link
//	Homepage home = new Homepage(driver);
//	home.clickcontact();
//	// -------------------------------------------------------------------------------------------
////click on create Contact lookup image->
//	ContactLookUpImgPage lookUp = new ContactLookUpImgPage(driver);
//	lookUp.clicklookUpImg();
//	Excel_Utility data = new Excel_Utility();
//	String fName = data.getExcel("Contact", 0, 0);
//	String lName = data.getExcel("Contact", 1, 0);
//	CreateContactPage con = new CreateContactPage(driver);
//	con.selectDropDown(driver);
//	con.enterContactData(fName, lName);
//	con.clickSaveButton();
//	// -------------------------------------------------------------------------------------------
//
//	ValidateContactPage validate = new ValidateContactPage(driver);
//	validate.validateContactFirstNAme(driver, fName);
//	validate.validateContactlastNAme(driver, lName);
//
//}
////--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//@Test
//public void m3()
//{
//	System.out.println("Hello");
//}
//
//}
