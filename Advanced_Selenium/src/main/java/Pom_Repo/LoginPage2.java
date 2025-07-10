package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	 public LoginPage2(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(name = "user_name")
	    private WebElement userTextField;

	    @FindAll({
	        @FindBy(css = "[type='password']"),
	        @FindBy(name = "user_password")
	    })
	    private WebElement passwordTextField;

	    @FindAll({
	        @FindBy(css = "[type='submit']"),
	        @FindBy(id = "submitButton")
	    })
	    private WebElement loginButton;

	    public void loginToVtiger(String name, String password) {
	        userTextField.sendKeys(name);
	        passwordTextField.sendKeys(password);
	        loginButton.click();
	    }
}
