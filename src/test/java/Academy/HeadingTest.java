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

public class HeadingTest extends BaseScript {
	private static Logger log = LogManager.getLogger(HeadingTest.class.getName());
	public WebDriver driver;
	LandingPage lp ;
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Browser Initialised");
		driver.get(prop.getProperty("url"));
		log.info("URL Hit");
	}

	@Test
	public void headingValidation() throws IOException {

		lp = new LandingPage(driver);

		Assert.assertEquals(lp.heading().getText(), "Featured Courses123");
		log.info("Heading Validation successfully Completed");
	}
	
	
	@Test
	public void topicValidation() throws IOException {
		Assert.assertEquals(lp.topic().getText(), "An Academy to Learn Earn & Shine  in your QA Career");
		log.info("Topic Validation successfully Completed");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
