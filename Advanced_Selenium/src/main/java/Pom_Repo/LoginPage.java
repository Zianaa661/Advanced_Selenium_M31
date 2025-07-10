package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(name="user_password")
	private WebElement PassWordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	//Business Logics/Libraries
	/**
	 * This method is used to login the Application
	 * @param Username
	 * @param Password
	 */
	public void loginToApp(String Username,String Password) {
		UserTextField.sendKeys(Username);
		PassWordTextField.sendKeys(Password);
		loginButton.click();
	}
	
	
	
	
}
