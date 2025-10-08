package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import applicationCore.ApplicationBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends ApplicationBase {
	@Test
	public void verifyAddNewsFunctionality() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
		HomePage homepage = new HomePage(driver);
		homepage.clickManageNewsInfo();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clcikAddNewsBtn();
		String newsInfo = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenewspage.enterNewsContent(newsInfo);
		managenewspage.clickSaveBtn();
		boolean isMessageDisplayed = managenewspage.isSucessMessageDisplayed();
		Assert.assertTrue(isMessageDisplayed, "News was not added successfully!");

	}

	@Test
	public void verifyNewsSearchInManageNewsList() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
		HomePage homepage = new HomePage(driver);
		homepage.clickManageNewsInfo();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickSearchBtnLnk();
		String newsInfo = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenewspage.enterSearchInputField(newsInfo);
		managenewspage.clickSearchBtn();
		String expectedNews = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		String actualNews = managenewspage.getDataFromSearchResult();
		Assert.assertEquals(actualNews, expectedNews, "The search result title does not match the expected news item.");

	}
}
