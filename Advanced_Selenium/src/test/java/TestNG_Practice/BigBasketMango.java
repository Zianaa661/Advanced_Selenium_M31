package TestNG_Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BigBasketMango {
	@Test
	public void bigBasket() throws Throwable {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		driver.findElement(By.xpath("//div[contains(@class,'place-content-start')]//input")).sendKeys("vegetable");
		List<WebElement> allMangoes = driver
				.findElements(By.xpath("//ul[@class='overscroll-contain']//span[contains(@class,'gFDEBU')]"));
		System.out.println("Total Mangoes Found: " + allMangoes.size());
		for (int i = 0; i < allMangoes.size(); i++) {
			WebElement ele = allMangoes.get(i);
			String str = ele.getText();
			System.out.println(str);
		}
		driver.findElement(By.xpath("(//ul[@class='overscroll-contain']//span[contains(@class,'gFDEBU')])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
		WebElement toast = driver.findElement(By.xpath("//p[contains(text(),'item has been added to your basket')]"));
		System.out.println(toast.getText());
driver.quit();
	}
}
