package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage1 {
	 private WebDriver driver;

	    // Locators
	    private By userTextField = By.name("user_name");
	    private By passwordTextField = By.name("user_password");
	    private By loginButton = By.id("submitButton");

	    // Constructor
	    public LoginPage1(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Actions
	    public void enterUserName(String username) {
	        WebElement userInput = driver.findElement(userTextField);
	        userInput.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        WebElement passInput = driver.findElement(passwordTextField);
	        passInput.sendKeys(password);
	    }

	    public void clickLogin() {
	        WebElement loginBtn = driver.findElement(loginButton);
	        loginBtn.click();
	    }
	    
	    
	    
	    public void LoginToApp(String name, String passowrd) {
	    	enterUserName(name);
	    	enterPassword(passowrd);
	    	clickLogin();
	    }
}
