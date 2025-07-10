package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class prdValidationPage {
	public prdValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validateProduct(WebDriver driver,String prdName)

	{

		String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		if (actData1.equals(prdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}

	}

}
