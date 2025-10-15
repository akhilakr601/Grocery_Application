package testScripts;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import applicationCore.ApplicationBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends ApplicationBase {
	@Test(description = "User is able to log out successfully after logging in")
	public void verifyLogoutFunctionality() throws IOException {
		String usernameValue = ExcelUtility.getStringData(0, 0, "LoginPageSheet");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPageSheet");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(usernameValue);
		loginPage.enterPassword(passwordValue);
		loginPage.checkRemember();
		loginPage.clickSignInBtn();

		HomePage homePage = new HomePage(driver);
		homePage.clickAdminLabel();
		homePage.clickLogout();

		String expected= "https://groceryapp.uniqassosiates.com/admin/login";
		String actual= loginPage.actualURL();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.logoutError);

	}

}
