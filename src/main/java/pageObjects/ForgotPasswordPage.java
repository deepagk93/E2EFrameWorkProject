package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	WebDriver driver;
	public ForgotPasswordPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user_email")
	private WebElement emailElement;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement sendMeInstructElement;
	
	public WebElement email() {
		return emailElement;
	}
	

	public WebElement sendMeInstruct() {
		return sendMeInstructElement;
	}
	
}
