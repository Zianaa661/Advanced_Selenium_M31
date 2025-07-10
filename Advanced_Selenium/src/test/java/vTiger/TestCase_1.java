package vTiger;

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

import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

public class TestCase_1 {

	public static void main(String[] args) throws Throwable {
		// Step1: Login to vtiger application

		FileInputStream fs = new FileInputStream("../Advanced_Selenium/data1.property");
		Properties p = new Properties();
		p.load(fs);
		String Browser = p.getProperty("Browser");
		String Uname = p.getProperty("Uname");
		String Password = p.getProperty("Password");
		//String PName = p.getProperty("PName");
		String Url = p.getProperty("Url");
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
		driver.findElement(By.name("user_name")).sendKeys(Uname);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// step2: click on product link
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		// step3:click on create product lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		FileInputStream fs1=new FileInputStream("C:/Users/Zeenat/OneDrive/Desktop/test1.xlsx");
		Workbook wk = WorkbookFactory.create(fs1);
		String ExcelValue=wk.getSheet("Product").getRow(0).getCell(0).getStringCellValue();
		// step4:Enter product name
		driver.findElement(By.name("productname")).sendKeys(ExcelValue);
		// step5:click on save Btn
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String verify = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		System.out.println(verify);
		// step6: verify whether the product is created in product Information page
		if (verify.equalsIgnoreCase(ExcelValue)) {
			System.out.println("Product typed verified");
		} else {
			System.out.println("Not Verified");
		}
		// step6: Logout
		Actions a = new Actions(driver);
		WebElement logoutdrops = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(logoutdrops).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		//close
		 driver.close();
	}

}
