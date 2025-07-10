package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateOrgPage {
	public ValidateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}


	/**
	 * This method is used to validate the campaign
	 * @param driver
	 * @param expData
	 */
	public void validateOrg(WebDriver driver,String OrgName)

	{
		String orgName1 = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (orgName1.contains(OrgName)) {
			System.out.println("Organization created");
		} else {
			System.out.println("Organization not created");
		}
}
}