package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.DeleteProductPage;
import Pom_Repo.Homepage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLookUpImgPage;

public class ProductAddingAndDelete {

	public static void main(String[] args) throws Throwable {
		// Step1: Login to vtiger application
		
		File_Utility flib = new File_Utility();
		String Browser = flib.getKeyAndValue("Browser");
		String Uname = flib.getKeyAndValue("Uname");
		String Password = flib.getKeyAndValue("Password");
		String Url = flib.getKeyAndValue("Url");
		

		WebDriver driver;
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("mozilla")) {
			driver = new EdgeDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get(Url);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(Uname, Password);
		//driver.findElement(By.name("user_name")).sendKeys(Uname);
		//driver.findElement(By.name("user_password")).sendKeys(Password);
		//driver.findElement(By.id("submitButton")).click();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.waitElementsToLoad(driver);
		wlib.MaximizeWindow(driver);
		
		//---------------------------------------------------
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		
		
		// step2: click on product link
		
		Homepage home = new Homepage(driver);
		home.clickProduct();
		
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		// step3:click on create product lookup image
		
		ProductLookUpImgPage lookUp = new ProductLookUpImgPage(driver);
		lookUp.clickPrdlookUpImg();
		
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		Excel_Utility excelData = new Excel_Utility();
		String prdName = excelData.getExcel("Product", 0, 0) + ranNum;
		
		
		
		
		//FileInputStream fs1 = new FileInputStream("C:/Users/Zeenat/OneDrive/Desktop/test1.xlsx");
		//Workbook wk = WorkbookFactory.create(fs1);
		//String prdName = wk.getSheet("Product").getRow(0).getCell(0).getStringCellValue() + ranNum;
		// step4:Enter product name
		//driver.findElement(By.name("productname")).sendKeys(prdName);
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterprdName(prdName);
		
		
		
		// step5:click on save Btn
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		prdPage.clickSaveButton();
		
		//String verify = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		//System.out.println(verify);
		// step6: verify whether the product is created in product Information page
		//if (verify.equalsIgnoreCase(prdName)) {
			//System.out.println("Product typed verified");
		//} else {
		//	System.out.println("Not Verified");
		//}
		// step2: click on product link
		
		home.clickProduct();
		
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		// ->select the product created checkbox
		
		 DeleteProductPage  deletePrd =new DeleteProductPage(driver);
		 deletePrd.selectPrdCheckBox(driver, prdName);
		// click on delete->
		 deletePrd.clickDeleteButton();

		 
		 
		//driver.findElement(By.xpath("//a[text()='" + prdName + "']/parent::td/preceding-sibling::td//input[@type='checkbox']")).click();
		// click on delete->

		//driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[2]")).click();
		// ->Handle the Alert popup
//		driver.switchTo().alert().accept();
		wlib.alertHandle(driver);
		 deletePrd.validatePrdDelete(driver, prdName);
//		List<WebElement> prdData = driver
//				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
//		boolean flag = false;
//		for (WebElement prd : prdData) {
//			String actPrd = prd.getText();
//			if (actPrd.contains(prdName)) {
//				flag = true;
//				break;
//			}
//		}
//
//		if (flag) {
//			System.out.println("Product is Deleted");
//		} else {
//			System.out.println("Product is  not Deleted");
//		}
//		
		
home.logoutApp();

	}

}
