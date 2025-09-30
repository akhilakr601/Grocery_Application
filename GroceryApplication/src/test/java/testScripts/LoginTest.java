package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import applicationCore.ApplicationBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends ApplicationBase {
	@Test
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
	}
	@Test
	public void verifyLoginWithValidUsernameInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();

	}
	@Test
	public void verifyLoginWithInvalidUsernameValidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(2, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
	}
	@Test
	public void verifyLoginWithInvalidCredentials() throws IOException {
		String usernameValue = ExcelUtility.getStringData(3, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
	}

}
