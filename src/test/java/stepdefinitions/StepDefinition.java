package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.BaseScript;

public class StepDefinition extends BaseScript {
	WebDriver driver;

	@Given("^Initialize Browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@When("^User enters (.+) and (.+) for the site$")
	public void user_enters_and_for_the_site(String username, String password) throws Throwable {
		LoginPage lop = new LoginPage(driver);
		lop.email().sendKeys(username);
		lop.password().sendKeys(password);
		System.out.println("Entered username and password");
		lop.login().click();
	}

	@Then("^Verify that user is suceesfully logged in$")
	public void verify_that_user_is_suceesfully_logged_in() throws Throwable {
		PortalHomePage php = new PortalHomePage(driver);
		Assert.assertTrue(php.searchBox().isDisplayed());
	}

	@And("^Navigate to the url \"([^\"]*)\"$")
	public void navigate_to_the_url_something(String strArg1) throws Throwable {
		driver.get(strArg1);
		
	}

	@And("^Click on login link in Home Page$")
	public void click_on_login_link_in_home_page() throws Throwable {
		LandingPage lp = new LandingPage(driver);
		if(lp.popUpList().size()>0) {
			lp.popUp().click();
		}
		lp.login();	
	}
	
	 @And("^Close Browser$")
	    public void close_browser() throws Throwable {
	        driver.quit();
	    }

}
