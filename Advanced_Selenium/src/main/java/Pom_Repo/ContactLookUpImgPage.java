package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUpImgPage {
public ContactLookUpImgPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(css="[alt='Create Contact...']")
private WebElement lookUpImg;

public WebElement getlookUpImgName() {
	return lookUpImg;
}

public void clicklookUpImg() {
	lookUpImg.click();
}



}
