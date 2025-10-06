package testScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import applicationCore.ApplicationBase;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTest extends ApplicationBase {
	@Test
	public void verifyAdminUsersCard() throws IOException {
		// Login function steps
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
		// Admin Page
		AdminPage adminPage = new AdminPage(driver);
		adminPage.clickAdminInfo();
	}

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
		String adminUsernameValue = ExcelUtility.getStringData(0, 0, "AdminPage");
		String adminPasswordValue = ExcelUtility.getStringData(0, 1, "AdminPage");
		// Admin Page
		AdminPage adminPage = new AdminPage(driver);
		adminPage.clickAdminInfo();
		adminPage.clickNewBtn();
		// add new user
		adminPage.enterUsername(adminUsernameValue);
		adminPage.enterPassword(adminPasswordValue);
		adminPage.selectUserType(2);
		adminPage.clickSaveBtn();

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
		AdminPage adminPage = new AdminPage(driver);
		adminPage.clickAdminInfo();
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
		
		//Admin
		AdminPage adminPage = new AdminPage(driver);
		adminPage.clickAdminInfo();
		adminPage.clickResetBtn();
		
		
		
		
	}
}
