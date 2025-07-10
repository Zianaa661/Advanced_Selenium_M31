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

import Pom_Repo.CamLookUpImgPage;
import Pom_Repo.CreateCampaignPage;
import Pom_Repo.Homepage;
import Pom_Repo.LoginPage;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		// Login to vtiger application->

		
		// Handle the PopUp->
		
		// click on save Btn->
		// verify whether the campaign name is created in campaign Information page
//Logout from the application.

		// Login to vtiger application->

		FileInputStream fs = new FileInputStream("../Advanced_Selenium/data1.property");
		Properties p = new Properties();
		p.load(fs);
		String Browser = p.getProperty("Browser");
		String Uname = p.getProperty("Uname");
		String Password = p.getProperty("Password");
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
		LoginPage login = new LoginPage(driver);
		login.loginToApp(Uname, Password);
		
		//driver.findElement(By.name("user_name")).sendKeys(Uname);
		//driver.findElement(By.name("user_password")).sendKeys(Password);
		//driver.findElement(By.id("submitButton")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		// -------------------------------------------------------------------------------------------
		// step2: click on product link
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		// step3:click on create product lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		FileInputStream fs1 = new FileInputStream("C:/Users/Zeenat/OneDrive/Desktop/test1.xlsx");
		Workbook wk = WorkbookFactory.create(fs1);
		String prdName = wk.getSheet("Product").getRow(0).getCell(0).getStringCellValue()+ranNum;
		// step4:Enter product name
		driver.findElement(By.name("productname")).sendKeys(prdName);
		// step5:click on save Btn
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		// -------------------------------------------------------------------------------------------
		// mouseOverOn more Link->
		
		Homepage home = new Homepage(driver);
		home.clickCampaign();
		//WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		//Actions a = new Actions(driver);
		//a.moveToElement(more).perform();

		// click on campaigns->
		//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		
		
		
		// -------------------------------------------------------------------------------------------
		// click on create campaign lookup image->
		CamLookUpImgPage CamLookUp=new CamLookUpImgPage(driver);
		CamLookUp.clicklookUpImg();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		// -------------------------------------------------------------------------------------------
		// Enter campaignName->
		
		String CamName = wk.getSheet("Campaign").getRow(0).getCell(0).getStringCellValue()+ranNum;
		System.out.println(CamName);

		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(CamName);
		// -------------------------------------------------------------------------------------------
		// Click on Product plus img->
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		// -------------------------------------------------------------------------------------------
		//Window Switching
				Set<String> allWins = driver.getWindowHandles();
				Iterator<String> it = allWins.iterator();

				while (it.hasNext())
				{
					String win = it.next();
					driver.switchTo().window(win);
					String title = driver.getTitle();
					if (title.contains("Products&action"))
					{
						break;
					}

				}
				// -------------------------------------------------------------------------------------------
				// Product name should be added to campaign createpage->
				driver.findElement(By.name("search_text")).sendKeys(prdName);
				driver.findElement(By.name("search")).click();
				
			//	driver.findElement(By.xpath("//a[text()='BlueTooth832']")).click();
				
				//Dynamic xpath
				driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
			}


	}


