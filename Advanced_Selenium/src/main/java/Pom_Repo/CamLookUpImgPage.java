package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CamLookUpImgPage {

	public CamLookUpImgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement lookUpImg;

	public WebElement getlookUpImgName() {
		return lookUpImg;
	}

	public void clicklookUpImg() {
		lookUpImg.click();
	}
}
