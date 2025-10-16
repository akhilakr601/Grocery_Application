package constants;

public class Constant {
	
	
	public static final String ConfigFile = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	
	public static final String TestDataFile = System.getProperty("user.dir")+"\\src\\test\\resources\\Grocery_App_Data.xlsx";
	
	
	
	public static final String validCredentialError = "User was unable to login with valid credentials";
	public static final String invalidPasswordError = "User is able to login with Invalid credentials";
	public static final String invalidUsernameError = "Error message was not displayed for invalid login!";
	public static final String invalidCredentialError = "Error message was not displayed for invalid credentials!";
	
	public static final String logoutError = "Logout failed: URL mismatch.";
	
	public static final String newAdminUserError = "Unable to create new user";
	public static final String searchAdminUserError = "Search result does not match expected username.";
	
	public static final String addNewsError ="News was not added successfully!";
	public static final String searchNewsError = "The search result title does not match the expected news item.";
	
	
	
	
	
	
}
