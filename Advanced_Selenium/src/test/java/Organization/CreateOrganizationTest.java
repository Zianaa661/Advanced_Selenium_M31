package Organization;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Deformatter;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CreateOrganizationPage;
import Pom_Repo.CreateProductPage;
import Pom_Repo.Homepage;
import Pom_Repo.LoginPage;
import Pom_Repo.OrganizationLookUpImg;
import Pom_Repo.ProductLookUpImgPage;
import Pom_Repo.ValidateOrgPage;
import Pom_Repo.prdValidationPage;

public class CreateOrganizationTest extends BaseClass  {
@Test(groups={"smmokeTest", "regressionTest"})
	public  void CreateOrganizationTest() throws Throwable {

		//File_Utility flib = new File_Utility();
		//String Browser = flib.getKeyAndValue("Browser");
		//String Uname = flib.getKeyAndValue("Uname");
		//String Password = flib.getKeyAndValue("Password");
		//String Url = flib.getKeyAndValue("Url");

//		WebDriver driver;
//		if (Browser.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (Browser.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		} else if (Browser.equalsIgnoreCase("mozilla")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new EdgeDriver();
//		}
		Homepage home = new Homepage(driver);
		//driver.get(Url);
		//LoginPage login = new LoginPage(driver);
		//login.loginToApp(Uname, Password);
		// driver.findElement(By.name("user_name")).sendKeys(Uname);
		// driver.findElement(By.name("user_password")).sendKeys(Password);
		// driver.findElement(By.id("submitButton")).click();
		WebDriver_Utility wlib = new WebDriver_Utility();
		//wlib.MaximizeWindow(driver);
		//wlib.waitElementsToLoad(driver);
		// -------------------------------------------------------------------------------------------

		// click on organizations link->
		home.clickOrganization();
		// driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		// -------------------------------------------------------------------------------------------

		// click on create organization lookup image->
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		OrganizationLookUpImg lookup=new OrganizationLookUpImg(driver);
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
		// driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
		// -------------------------------------------------------------------------------------------

		// String phNumb = data1.getExcel1("Organization", 1, 0);

		// driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phNumb);
		// -------------------------------------------------------------------------------------------
		// String mailID = data1.getExcel1("Organization", 2, 0);
		// driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(mailID);
		// -------------------------------------------------------------------------------------------

		// click on save Btn->
		// driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		// -------------------------------------------------------------------------------------------
		// verify whether the organization is created in Organization Information page
		ValidateOrgPage validate = new ValidateOrgPage(driver);
		validate.validateOrg(driver, OrgName);
//		String orgName1 = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if (orgName1.contains(OrgName)) {
//			System.out.println("Organization created");
//		} else {
//			System.out.println("Organization not created");
//		}
		// -------------------------------------------------------------------------------------------
		// Logout from the application.

		//home.logoutApp();
		// Actions a = new Actions(driver);
		// WebElement logoutdrops =
		// driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		// a.moveToElement(logoutdrops).perform();
		// driver.findElement(By.linkText("Sign Out")).click();

	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
@Test
public void ProductTest() throws Throwable {
	// Step1: Login to vtiger application
	Java_Utility jlib = new Java_Utility();
	int ranNum = jlib.getRandom();
	Homepage home = new Homepage(driver);
	home.clickProduct();
	ProductLookUpImgPage lookUp = new ProductLookUpImgPage(driver);
	lookUp.clickPrdlookUpImg();
	Excel_Utility excelData = new Excel_Utility();
	String prdName = excelData.getExcel("Product", 0, 0) + ranNum;
	// step4:Enter product name
	CreateProductPage prdPage = new CreateProductPage(driver);
	prdPage.enterprdName(prdName);
	// step5:click on save Btn
	prdPage.clickSaveButton();
	Thread.sleep(2000);
	prdValidationPage validate = new prdValidationPage(driver);
	validate.validateProduct(driver, prdName);


}

}
