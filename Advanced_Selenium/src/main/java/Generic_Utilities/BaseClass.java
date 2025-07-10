package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Pom_Repo.Homepage;
import Pom_Repo.LoginPage;

public class BaseClass  {
	public WebDriver driver;
	static WebDriver sdriver;

	@BeforeTest(groups={"smmokeTest", "regressionTest"})
	public void BT() {

	}
	//@Parameters("Browser") only applicable for cross-browser testing
	@BeforeClass(groups={"smmokeTest", "regressionTest"})
	//public void BC(String Browser) throws Throwable {
	public void BC() throws Throwable {
		System.out.println("Browser Launching");
		//reading keys from Property Files
		
		File_Utility data = new File_Utility();
		String Browser = data.getKeyAndValue("Browser");
		
		//reading keys from cmd prompt
		//String Browser=System.getProperty("browser");

		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("mozilla")) {
			driver = new EdgeDriver();
		} else {
			driver = new EdgeDriver();
		}
		System.out.println("Browser Launching");
		sdriver=driver;

	}
	//@Parameters({"Url","Uname","Password"}) only applicable for cross-browser testing


	@BeforeMethod(groups={"smmokeTest", "regressionTest"})
//	public void BM(String Url,String Uname,String Password) throws Throwable {
	public void BM() throws Throwable {
		//reading keys from Property Files
		
		File_Utility data = new File_Utility();
		String Browser = data.getKeyAndValue("Browser");
		String Uname = data.getKeyAndValue("Uname");
		String Password = data.getKeyAndValue("Password");
		String Url = data.getKeyAndValue("Url");
		
		
		
		
		//reading keys from cmd prompt
		//String Url=System.getProperty("Url");
		//String Uname=System.getProperty("Uname");
		//String Password=System.getProperty("pw");
		driver.get(Url);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(Uname, Password);
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.waitElementsToLoad(driver);
		wlib.MaximizeWindow(driver);
		System.out.println("Login to Application");

	}

	@AfterMethod(groups={"smmokeTest", "regressionTest"})
	public void AM() {
		Homepage home = new Homepage(driver);
		home.logoutApp();
		System.out.println("Logout from Application");

	}

	@AfterClass(groups={"smmokeTest", "regressionTest"})
	public void AC() {
		driver.quit();
		System.out.println("close the Browser");
		System.out.println("--------------------------------------------------------------------------");
	}

	@AfterTest(groups={"smmokeTest", "regressionTest"})
	public void AT() {

	}
}
