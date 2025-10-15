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

	@FindBy(name = "username")WebElement usernameElement;
	@FindBy(name = "password")WebElement passwordElement;
	@FindBy(css = "label[for='remember']")WebElement rememberBox;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signInBtn;
	
    @FindBy(xpath = "//p[text()='Dashboard']")WebElement dashboardTile;
    @FindBy(xpath = "//b[text()='7rmart supermarket']")WebElement loginTitle;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement errorMsgElem;
    
    
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
	public boolean isDashbordDisplayed() {
		return dashboardTile.isDisplayed();
	}
	public String isTitleDisplayed() {
		return loginTitle.getText();
	}
	public boolean isEroorMsgDisplayed() {
		return errorMsgElem.isDisplayed();
	}
	public boolean isUsernameFieldDisplayed() {
		
		return usernameElement.isDisplayed();
	}
	
	public String actualURL()
	{
		return driver.getCurrentUrl();
	}
}
