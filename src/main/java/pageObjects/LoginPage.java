package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(@href,'password/new')]")
	private WebElement forgotPasswordElement;
	
	@FindBy(id="user_email")
	private WebElement emailElement;
	
	@FindBy(id="user_password")
	private WebElement passwordElement;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement loginElement;
	
	public WebElement email() {
		return emailElement;
	}
	
	public WebElement password() {
		return passwordElement;
	}
	
	public WebElement login() {
		return loginElement;
	}
	
	public ForgotPasswordPage forgotPassword() {
		forgotPasswordElement.click();
		return new ForgotPasswordPage(driver);
		
	}
}
