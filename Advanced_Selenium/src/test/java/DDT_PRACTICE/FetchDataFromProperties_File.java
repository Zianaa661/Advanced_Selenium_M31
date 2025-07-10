package DDT_PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchDataFromProperties_File {
	public static void main(String[] args) throws Throwable {

		FileInputStream f = new FileInputStream("../Advanced_Selenium/data.property");
		Properties p = new Properties();
		p.load(f);
		String brow = p.getProperty("Browser");
		String url = p.getProperty("Url");
		String id = p.getProperty("Id");
		String pw = p.getProperty("Pw");
		WebDriver driver;
		if (brow.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (brow.equalsIgnoreCase("firefox")) {
			driver = new ChromeDriver();
		} else if (brow.equalsIgnoreCase("edge")) {
			driver = new ChromeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(pw);
		driver.findElement(By.name("user_password")).sendKeys(id);
		driver.findElement(By.id("submitButton")).click();

	}
}
