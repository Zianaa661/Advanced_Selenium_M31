package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidationCampaignPage {
public ValidationCampaignPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
	
}


/**
 * This method is used to validate the campaign
 * @param driver
 * @param expData
 */
public void validateCamp(WebDriver driver,String expData)

{
	String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

	if (actData.equals(expData)) {
		System.out.println("campaign Name is Created");
	} else {
		System.out.println("Campaign name is not created");
	}

}



public void validateProduct(WebDriver driver,String prdName)

{

	String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
	if (actData1.equals(prdName)) {
		System.out.println("Product Name is Created");
	} else {
		System.out.println("Product name is not created");
	}

}
}
