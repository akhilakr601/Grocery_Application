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

	public void clcikAddNewsBtn() {
		addNewsBtn.click();
	}

	public void enterNewsContent(String newsData) {
		addNewsContent.sendKeys(newsData);
	}

	public void clickSaveBtn() {
		saveBtn.click();
	}

	public boolean isSucessMessageDisplayed() {
		return addNewsSuccessAlert.isDisplayed();
	}

	public void clickSearchBtnLnk() {
		searchNewsLnk.click();

	}

	public void enterSearchInputField(String newsSearchData) {
		searchNewsInput.sendKeys(newsSearchData);
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

	public String getDataFromSearchResult() {
		return searchResultTable.getText();
	}
}
