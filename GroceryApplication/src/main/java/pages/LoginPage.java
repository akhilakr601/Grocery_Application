package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement usernameElement;
	@FindBy(name = "password")
	WebElement passwordElement;
	@FindBy(css = "label[for='remember']")
	WebElement rememberBox;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInBtn;

	public void enterUsername(String usernameValue) {
		usernameElement.sendKeys(usernameValue);
	}

	public void enterPassword(String passwordValue) {
		passwordElement.sendKeys(passwordValue);
	}

	public void checkRemember() {
		rememberBox.click();
	}

	public void clickSignInBtn() {
		signInBtn.click();
	}

}
