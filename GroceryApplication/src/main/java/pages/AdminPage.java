package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;//

public class AdminPage {
	public WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//a[@class = 'small-box-footer']")
//	WebElement adminInfolbl;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addNewUser;
	@FindBy(id = "username")
	WebElement adminUsernameElem;
	@FindBy(id = "password")
	WebElement adminPasswordElem;
	@FindBy(id = "user_type")
	WebElement userTypeDrop;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveBtn;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchUserBtnElem;
	@FindBy(id = "un")
	WebElement searchUserElem;
	@FindBy(id = "ut")
	WebElement searchUserTypeDrop;
	@FindBy(name = "Search")
	WebElement searchUserBtn;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetUserElem;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement addUserAlert;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]") WebElement searchResultTable;

//	public void clickAdminInfo() {
//		adminInfolbl.click();
//	}
	public void clickNewBtn() {
		addNewUser.click();
	}

	public void enterUsername(String adminUsernameValue) {
		adminUsernameElem.sendKeys(adminUsernameValue);
	}

	public void enterPassword(String adminPasswordValue) {
		adminPasswordElem.sendKeys(adminPasswordValue);
	}

	public void selectUserType(int index) {
		Select userType = new Select(userTypeDrop);
		userType.selectByIndex(index);

	}

	public void clickSaveBtn() {
		saveBtn.click();
	}

	public void clickSearchBtn() {
		searchUserBtnElem.click();
	}

	public void enterSearchUsername(String searchUserValue) {
		searchUserElem.sendKeys(searchUserValue);
	}

	public void selectSearchUserType(int index) {
		Select searchUserType = new Select(searchUserTypeDrop);
		searchUserType.selectByIndex(index);

	}

	public void clickSearchUserBtn() {
		searchUserBtn.click();
	}

	public void clickResetBtn() {
		resetUserElem.click();
	}

	public boolean isSuccessMessageDisplayed() {
		return addUserAlert.isDisplayed();
	}
	public String getSearchResult() {
		return searchResultTable.getText();
		
	}
}
