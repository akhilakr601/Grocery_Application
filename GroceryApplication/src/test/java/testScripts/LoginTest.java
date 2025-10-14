package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import applicationCore.ApplicationBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends ApplicationBase {
	@Test(priority = 1,description = "User is trying to lgin with valid credentials",groups = {"smoke"})
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
		// Assertion
		boolean dashboardDisplay = loginPage.isDashbordDisplayed();
		Assert.assertTrue(dashboardDisplay, "User was unable to login with valid credentials");
	}

	@Test(priority = 2,retryAnalyzer = retry.Retry.class )
	public void verifyLoginWithValidUsernameInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(11, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
		// Assertion
		String expected = "7rmart supermarket";
		String actual = loginPage.isTitleDisplayed();
		Assert.assertEquals(actual, expected, "User is able to login with Invalid credentials");
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidUsernameValidPassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(2, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
		// Asserion
		boolean isErrorDisplayed = loginPage.isEroorMsgDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error message was not displayed for invalid login!");

	}

	@Test(priority = 4,groups = {"smoke"},dataProvider = "loginProvider")
	public void verifyLoginWithInvalidCredentials(String usernameValue,String passwordValue) throws IOException {
//		String usernameValue = ExcelUtility.getStringData(3, 0, "LoginPageSheet");
//		String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPageSheet");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};}
}
