package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getMailId() {
		return mailId;
	}

	public WebElement getPhnNum() {
		return phnNum;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgName;
	
	@FindBy(xpath = "//input[@name='email1']")
	private WebElement mailId;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phnNum;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	
	

	public void enterOrgnaizationData(String OrgName,String MailID,String phnNumB ) {
		orgName.sendKeys(OrgName);
		mailId.sendKeys(MailID);
		phnNum.sendKeys(phnNumB);
		saveButton.click();
		
		
	}


}
