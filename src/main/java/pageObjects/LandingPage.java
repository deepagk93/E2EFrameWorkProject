package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = "a[href*='sign_in']")
	private WebElement loginElement;
	
	@FindBy(xpath = "//div[@class='pull-left']/h2")
	private WebElement headingElement;
	
	@FindBy(xpath = "//div[@class='nav-outer clearfix']")
	private WebElement navBarElement;
	
	@FindBy(css = "div[class*='header-text'] h2 span")
	private WebElement topicElement;
	
	@FindBy(xpath = "//button[text()='NO THANKS']")
	private List<WebElement> popUpElementList;
	
	@FindBy(xpath = "//button[text()='NO THANKS']")
	private WebElement popUpElement;
	
	public List<WebElement> popUpList() {
		return popUpElementList;
	}
	
	public WebElement popUp() {
		return popUpElement;
	}
	
	public LoginPage login() {
		loginElement.click();
		return new LoginPage(driver);
		
	}
	
	public WebElement heading() {
		return headingElement;
	}
	
	public WebElement navBar() {
		return navBarElement;
	}
	
	public WebElement topic() {
		return topicElement;
	}
	
	
}
