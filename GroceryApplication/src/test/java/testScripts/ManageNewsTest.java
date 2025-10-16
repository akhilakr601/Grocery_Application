package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import applicationCore.ApplicationBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends ApplicationBase {
	HomePage homePage;
	ManageNewsPage manageNews;
	@Test
	public void verifyAddNewsFunctionality() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue).enterPassword(passwordValue).checkRemember();
		homePage = loginPage.clickSignInBtn();
		manageNews= homePage.clickManageNewsInfo();
		String newsInfo = ExcelUtility.getStringData(0, 0, "ManageNewsPage");

		manageNews.clickAddNewsBtn().enterNewsContent(newsInfo).clickSaveBtn();
		
		boolean isMessageDisplayed = manageNews.isSucessMessageDisplayed();
		Assert.assertTrue(isMessageDisplayed, Constant.addNewsError);

	}

	@Test
	public void verifyNewsSearchInManageNewsList() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue).enterPassword(passwordValue).checkRemember();
		homePage = loginPage.clickSignInBtn();
		manageNews=  homePage.clickManageNewsInfo();
		String newsInfo = ExcelUtility.getStringData(0, 0, "ManageNewsPage");

		manageNews.clickSearchBtnLnk().enterSearchInputField(newsInfo).clickSearchBtn();
//		String expectedNews = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		String actualNews = manageNews.getDataFromSearchResult().trim();
		
		Assert.assertEquals(actualNews, newsInfo.trim(), Constant.searchNewsError);

	}
}
