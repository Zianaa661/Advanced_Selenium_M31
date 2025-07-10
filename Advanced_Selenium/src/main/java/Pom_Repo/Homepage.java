 package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class Homepage {

	WebDriver driver; //  driver at class level
	WebDriver_Utility act = new WebDriver_Utility();

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdmLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreLink;

	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement campaignsLink;

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement orgLink;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	/**
	 * 
	 * @return
	 */

	public WebElement getMoreLink() {
		return moreLink;
	}
	/**
	 * 
	 * @return
	 */

	public WebElement getProductLink() {
		return productLink;
	}
	/**
	 * 
	 * @return
	 */

	public WebElement getContactLink() {
		return contactLink;
	}
	/**
	 * 
	 * @return
	 */

	public WebElement getOrgLink() {
		return orgLink;
	}
	/**
	 * 
	 * @return
	 */

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
/**
 * 
 */
	public void clickCampaign() {
		act.moveToElement(driver, moreLink);
		campaignsLink.click();
	}
	/**
	 * 
	 */

	public void clickOrganization() {
		orgLink.click();
	}
	/**
	 * 
	 */

	public void clickProduct() {
		productLink.click();
	}
/**
 * 
 */
	public void clickcontact() {
		contactLink.click();
	}
/**
 * 
 */
	public void logoutApp() {
		act.moveToElement(driver, AdmLink);
		signOutLink.click();
	}

}
