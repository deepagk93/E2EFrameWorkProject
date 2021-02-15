package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseScript;

public class HomePageTest extends BaseScript {
	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Browser Initialised");

	}

	@Test(dataProvider = "getdata")
	public void basePageNavigation(String user, String pass) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("URL Hit");
		LandingPage lp = new LandingPage(driver);
		LoginPage lop = lp.login();		 
		lop.email().sendKeys(user);
		lop.password().sendKeys(pass);
//		lop.login().click();
		
		ForgotPasswordPage fp = lop.forgotPassword();		
		fp.email().sendKeys("xxxx");
		fp.sendMeInstruct().click();
		
		log.info("User login for User: " + user);

	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[2][2];

		data[0][0] = "restricteduser@gmail";
		data[0][1] = "restricteduserpassword";

		data[1][0] = "nonrestricteduser@gmail";
		data[1][1] = "nonrestricteduserpassword";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
