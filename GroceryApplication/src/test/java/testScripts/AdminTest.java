package testScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import applicationCore.ApplicationBase;
import constants.Constant;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminTest extends ApplicationBase {

	HomePage homePage;
	AdminPage adminPage;
	@Test(priority = 1, description = "user is trying to create new users")

	public void verifyNewButtonFunctionality() throws IOException {
		// Login function steps
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue).enterPassword(passwordValue).checkRemember();
		homePage=loginPage.clickSignInBtn();
		adminPage=homePage.clickAdminInfo();
		adminPage.clickNewBtn();

		// Accept Data
		RandomDataUtility random = new RandomDataUtility();
		String adminUsernameValue = random.createRandomUserName();
		String adminPasswordValue = random.createRandomPassword();

		// add new user
		adminPage.enterUsername(adminUsernameValue).enterPassword(adminPasswordValue).selectUserType(2).clickSaveBtn();
		
		boolean isSuccessMessageVisible = adminPage.isSuccessMessageDisplayed();
		Assert.assertTrue(isSuccessMessageVisible, Constant.newAdminUserError);
		
	}

	@Test(priority = 3, description = "user is trying to search newly created user")
	public void verifySearchFunctionality() throws IOException {
		// Login function steps
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue).enterPassword(passwordValue).checkRemember();
		homePage= loginPage.clickSignInBtn();
		// search
		adminPage=  homePage.clickAdminInfo();
		adminPage.clickSearchBtn();
		String searchUserValue = ExcelUtility.getStringData(0, 0, "AdminPageSheet");
		adminPage.enterSearchUsername(searchUserValue).selectSearchUserType(2).clickSearchUserBtn();
		String actualResult = adminPage.getSearchResult();
		Assert.assertEquals(actualResult, searchUserValue,Constant.searchAdminUserError);

	}

	@Test(priority = 2,description = "User is doing refesh the page ")
	public void verifyResetFunctionality() throws IOException {
		// Login function steps
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue).enterPassword(passwordValue).checkRemember();
		homePage =  loginPage.clickSignInBtn();
		homePage.clickAdminInfo();
		// Admin
		adminPage.clickResetBtn();

	}
}
