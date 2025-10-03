package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import applicationCore.ApplicationBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends ApplicationBase{
	@Test
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
		
		
		
	}

}
