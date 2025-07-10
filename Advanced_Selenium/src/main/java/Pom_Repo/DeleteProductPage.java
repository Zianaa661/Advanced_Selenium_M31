package Pom_Repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {
public DeleteProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="(//input[@class='crmbutton small delete'])[2]")
private WebElement deleteButton;

public void selectPrdCheckBox(WebDriver driver, String prdName) {
	driver.findElement(
			By.xpath("//a[text()='" + prdName + "']/parent::td/preceding-sibling::td//input[@type='checkbox']"))
			.click();
}

public void clickDeleteButton() {
	
			deleteButton.click();
}


public void validatePrdDelete(WebDriver driver, String prdName) {
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
