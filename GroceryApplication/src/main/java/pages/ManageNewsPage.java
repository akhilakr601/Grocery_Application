package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href, '/admin/news/add')]")
	WebElement addNewsBtn;
	@FindBy(id = "news")
	WebElement addNewsContent;
	@FindBy(name = "create")
	WebElement saveBtn;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement addNewsSuccessAlert;
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement searchNewsLnk;
	@FindBy(name = "un")
	WebElement searchNewsInput;
	@FindBy(name = "Search")
	WebElement searchBtn;
	@FindBy(xpath = "//tr[1]/td[1]")
	WebElement searchResultTable;

	public ManageNewsPage clickAddNewsBtn() {
		addNewsBtn.click();
		return this;
	}

	public ManageNewsPage enterNewsContent(String newsData) {
		addNewsContent.sendKeys(newsData);
		return this;
	}

	public ManageNewsPage clickSaveBtn() {
		saveBtn.click();
		return this;
	}

	public boolean isSucessMessageDisplayed() {
		return addNewsSuccessAlert.isDisplayed();
	}

	public ManageNewsPage clickSearchBtnLnk() {
		searchNewsLnk.click();
		return this;

	}

	public ManageNewsPage enterSearchInputField(String newsSearchData) {
		searchNewsInput.sendKeys(newsSearchData);
		return this;
	}

	public ManageNewsPage clickSearchBtn() {
		searchBtn.click();
		return this;
	}

	public String getDataFromSearchResult() {
		return searchResultTable.getText();
	}
}
