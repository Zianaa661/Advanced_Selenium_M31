package vTiger;

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

public class ProductAddingAndDelete {

	public static void main(String[] args) throws Throwable {
		// Step1: Login to vtiger application

		FileInputStream fs = new FileInputStream("../Advanced_Selenium/data1.property");
		Properties p = new Properties();
		p.load(fs);
		String Browser = p.getProperty("Browser");
		String Uname = p.getProperty("Uname");
		String Password = p.getProperty("Password");
		// String PName = p.getProperty("PName");
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
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		// step2: click on product link
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		// step3:click on create product lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		FileInputStream fs1 = new FileInputStream("C:/Users/Zeenat/OneDrive/Desktop/test1.xlsx");
		Workbook wk = WorkbookFactory.create(fs1);
		String prdName = wk.getSheet("Product").getRow(0).getCell(0).getStringCellValue() + ranNum;
		// step4:Enter product name
		driver.findElement(By.name("productname")).sendKeys(prdName);
		// step5:click on save Btn
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String verify = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		System.out.println(verify);
		// step6: verify whether the product is created in product Information page
		if (verify.equalsIgnoreCase(prdName)) {
			System.out.println("Product typed verified");
		} else {
			System.out.println("Not Verified");
		}
		// step2: click on product link
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		// ->select the product created checkbox
		driver.findElement(
				By.xpath("//a[text()='" + prdName + "']/parent::td/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		// click on delete->

		driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[2]")).click();
		// ->Handle the Alert popup
		driver.switchTo().alert().accept();
		List<WebElement> prdData = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		boolean flag = false;
		for (WebElement prd : prdData) {
			String actPrd = prd.getText();
			if (actPrd.contains(prdName)) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("Product is Deleted");
		} else {
			System.out.println("Product is  not Deleted");
		}

	}

}
