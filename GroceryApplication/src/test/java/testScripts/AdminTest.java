package testScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import applicationCore.ApplicationBase;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminTest extends ApplicationBase {

	/**
	 * public void verifyAdminUsersCard() throws IOException { // Login function
	 * steps String usernameValue = ExcelUtility.getStringData(0, 0,
	 * "LoginPageSheet"); String passwordValue = ExcelUtility.getStringData(0, 1,
	 * "LoginPageSheet"); LoginPage loginPage = new LoginPage(driver);
	 * loginPage.enterUsername(usernameValue);
	 * loginPage.enterPassword(passwordValue); loginPage.checkRemember();
	 * loginPage.clickSignInBtn(); // Admin Page HomePage homepage = new
	 * HomePage(driver); homepage.clickAdminInfo(); }
	 **/

	@Test
	public void verifyNewButtonFunctionality() throws IOException {
		// Login function steps
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();

		// Accept Data
		RandomDataUtility random = new RandomDataUtility();
		
		String adminUsernameValue = random.createRandomUserName();
		String adminPasswordValue = random.createRandomPassword();
		// Home Page
		HomePage homepage = new HomePage(driver);
		homepage.clickAdminInfo();
		// Admin page
		AdminPage adminPage = new AdminPage(driver);
		adminPage.clickNewBtn();
		// add new user
		adminPage.enterUsername(adminUsernameValue);
		adminPage.enterPassword(adminPasswordValue);
		adminPage.selectUserType(2);
		adminPage.clickSaveBtn();
		boolean isSuccessMessageVisible = adminPage.isSuccessMessageDisplayed();
		Assert.assertTrue(isSuccessMessageVisible, "Success message not displayed after saving new user");

	}

	@Test
	public void verifySearchFunctionality() throws IOException {
		// Login function steps
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
		// search
		HomePage homepage = new HomePage(driver);
		homepage.clickAdminInfo();
		AdminPage adminPage = new AdminPage(driver);
//		adminPage.clickNewBtn();
		adminPage.clickSearchBtn();
		String searchUserValue = ExcelUtility.getStringData(0, 0, "AdminPage");
		adminPage.enterSearchUsername(searchUserValue);
		adminPage.selectSearchUserType(2);
		adminPage.clickSearchUserBtn();

	}

	@Test
	public void verifyResetFunctionality() throws IOException {
		// Login function steps
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
		HomePage homepage = new HomePage(driver);
		homepage.clickAdminInfo();
		// Admin
		AdminPage adminPage = new AdminPage(driver);

		adminPage.clickResetBtn();

	}
}
