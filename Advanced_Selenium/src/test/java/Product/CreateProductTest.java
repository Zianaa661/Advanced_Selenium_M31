package Product;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.Homepage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLookUpImgPage;
import Pom_Repo.ValidationCampaignPage;
import Pom_Repo.prdValidationPage;

import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

public class CreateProductTest extends BaseClass {
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
