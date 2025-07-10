package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateContactPage {
public ValidateContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public void validateContactFirstNAme(WebDriver driver,String name)
{
	String actdata1 = driver.findElement(By.id("dtlview_First Name")).getText();
	if (actdata1.contains(name)) {
		System.out.println("contact first Name is Created");
	} else {

		System.out.println("contact first is not Created");
	}
}

public void validateContactlastNAme(WebDriver driver,String name)
{
	String actdata = driver.findElement(By.id("dtlview_Last Name")).getText();
	if (actdata.contains(name)) {
		System.out.println("contact last Name is Created");
	} else {

		System.out.println("contact last NAme is not Created");
	}


}
}
