package testScripts;

import java.io.IOException;

import org.testng.Assert;
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
		//Assertion
		boolean dashboardDisplay = loginPage.isDashbordDisplayed();
		Assert.assertTrue(dashboardDisplay,"User was unable to login with valid username with valid credentials");
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
		//Assertion
		String expected = "7rmart supermarket";
		String actual = loginPage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,"User was able to login with Invalid credentials");
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
		//Asserion
//		boolean isErrorDisplayed = loginPage.isEroorMsgDisplayed();
//		Assert.assertFalse(isErrorDisplayed, "Error message is visible for valid credentials!");
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
