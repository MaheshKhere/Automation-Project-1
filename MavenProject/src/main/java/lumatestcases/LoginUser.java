package lumatestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUser {
	public WebDriver driver;

	public LoginUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// PageFactory.initElements(driver, this);
		// this will trigger all elements associated with @FindBy
		// this refer to current class driver.
		// this method is execute first because it inside the constructor.

	}

	@FindBy(xpath = "//a[@class='logo']/img")
	WebElement Logo;

	@FindBy(linkText = "Sign In")
	WebElement SignInLink;

	@FindBy(id = "email")
	WebElement Email;

	@FindBy(id = "pass")
	WebElement Pass;

	@FindBy(xpath = "//button[@class='action login primary']")
	WebElement LoginButton;

	public void verifylink() {
		SignInLink.click();
	}

	public void ClickLogo() {
		Logo.click();
	}

	public void LoginDetails() {

		Email.sendKeys("userpeter12@gmail.com");
		Pass.sendKeys("Userpeter2@");
		LoginButton.click();
	}
}
