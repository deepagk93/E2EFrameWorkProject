package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.BaseScript;

public class NavigationBarTest extends BaseScript {
	private static Logger log = LogManager.getLogger(NavigationBarTest.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Browser Initialised");
		driver.get(prop.getProperty("url"));
		log.info("URL Hit");
	}

	@Test()
	public void navBarValidation() throws IOException {

		LandingPage lp = new LandingPage(driver);

		Assert.assertTrue(lp.navBar().isDisplayed());
		log.info("Navigation Bar Validation successfully Completed");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
