package Campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CamLookUpImgPage;
import Pom_Repo.CreateCampaignPage;
import Pom_Repo.CreateProductPage;
import Pom_Repo.Homepage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLookUpImgPage;
import Pom_Repo.ValidationCampaignPage;
import Pom_Repo.WindowSwitchingPage;

public class CreateCampaignWithProductTest extends BaseClass  {
@Test(groups="smmokeTest")
	public  void CreateCampaignWithProductTest() throws Throwable {
		// Login to vtiger application->
		// Handle the PopUp->
		// click on save Btn->
		// verify whether the campaign name is created in campaign Information page
		// Logout from the application.
		// Login to vtiger application->

//		FileInputStream fs = new FileInputStream("../Advanced_Selenium/data1.property");
//		Properties p = new Properties();
//		p.load(fs);
//		String Browser = p.getProperty("Browser");
//		String Uname = p.getProperty("Uname");
//		String Password = p.getProperty("Password");
//		String Url = p.getProperty("Url");

//		File_Utility data = new File_Utility();
//		String Browser = data.getKeyAndValue("Browser");
//		String Uname = data.getKeyAndValue("Uname");
//		String Password = data.getKeyAndValue("Password");
//		String Url = data.getKeyAndValue("Url");

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
		//driver.get(Url);
		//LoginPage login = new LoginPage(driver);
		//login.loginToApp(Uname, Password);

		// driver.findElement(By.name("user_name")).sendKeys(Uname);
		// driver.findElement(By.name("user_password")).sendKeys(Password);
		// driver.findElement(By.id("submitButton")).click();
		//WebDriver_Utility wlib = new WebDriver_Utility();
		//wlib.MaximizeWindow(driver);
		//wlib.waitElementsToLoad(driver);
		// ------------------------------
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandom();
		// -------------------------------------------------------------------------------------------
		// step2: click on product link
		//driver.findElement(By.xpath("//a[text()='Products']")).click();

		Homepage home = new Homepage(driver);
		home.clickProduct();

		// step3:click on create product lookup image
		// driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		ProductLookUpImgPage lookUp = new ProductLookUpImgPage(driver);
		lookUp.clickPrdlookUpImg();

		// FileInputStream fs1 = new
		// FileInputStream("C:/Users/Zeenat/OneDrive/Desktop/test1.xlsx");
		// Workbook wk = WorkbookFactory.create(fs1);
		// String prdName =
		// wk.getSheet("Product").getRow(0).getCell(0).getStringCellValue() + ranNum;

		Excel_Utility excelData = new Excel_Utility();
		String prdName = excelData.getExcel("Product", 0, 0) + ranNum;

		// step4:Enter product name
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterprdName(prdName);
		// step5:click on save Btn
		prdPage.clickSaveButton();

		// driver.findElement(By.name("productname")).sendKeys(prdName);
		// step5:click on save Btn
		// driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		// -------------------------------------------------------------------------------------------
		// mouseOverOn more Link->
		// click on campaigns->
		home.clickCampaign();
// click on create campaign lookup image->
		CamLookUpImgPage CamLookUp = new CamLookUpImgPage(driver);
		CamLookUp.clicklookUpImg();

		// WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		// Actions a = new Actions(driver);
		// a.moveToElement(more).perform();

		// click on campaigns->
		// driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		// -------------------------------------------------------------------------------------------
		// click on create campaign lookup image->
		// driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		// -------------------------------------------------------------------------------------------
		// Enter campaignName->
	//	;
		// CamName = wk.getSheet("Campaign").getRow(0).getCell(0).getStringCellValue() +
		// ranNum;
		// System.out.println(CamName);
		String CamName = excelData.getExcel("Campaign", 0, 0) + ranNum;

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.enterCampName(CamName);
		// driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(CamName);
		// -------------------------------------------------------------------------------------------
		// Click on Product plus img->
		
		WindowSwitchingPage win=new WindowSwitchingPage(driver);
		win.clickPrdLookUpImgInCam();
		//driver.findElement(By.xpath("//img[@alt='Select']")).click();
		// -------------------------------------------------------------------------------------------
		// Window Switching
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.windowSwitching(driver, "Products&action");
		// -------------------------------------------------------------------------------------------
		// Product name should be added to campaign createpage->
		
		win.enterPrdDetails(prdName);
	
		//driver.findElement(By.name("search_text")).sendKeys(prdName);
		//driver.findElement(By.name("search")).click();
		// driver.findElement(By.xpath("//a[text()='BlueTooth832']")).click();
		// Dynamic xpath
		win.enterPrdNameInCamp(driver, prdName);
		//driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
		// Window Switching
		wlib.windowSwitching(driver, "Campaigns&action");
		campPage.clickSaveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		ValidationCampaignPage validate=new ValidationCampaignPage(driver);
		validate.validateCamp(driver, CamName);
		validate.validateProduct(driver, prdName);
		
//		
//		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
//
//		if (actData.contains(CamName)) {
//			System.out.println("Campaigns Name is Created");
//		} else {
//			System.out.println("Campaigns name not created");
//		}
//
//		String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
//		if (actData1.equals(prdName)) {
//			System.out.println("Product Name is Created");
//		} else {
//			System.out.println("Product name is not created");
//		}
		//home.logoutApp();

		// WebElement AmdLink =
		// driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

	}

}
