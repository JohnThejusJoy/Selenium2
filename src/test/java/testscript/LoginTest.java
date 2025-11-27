package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Constant;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase{
	public HomePage home;//object initialisation
@Test(priority = 1, description = "To verify the login using valid credentials", retryAnalyzer = retry.Retry.class)//Will  be displayed in report
public void verifyLoginwithValidCredentials() throws IOException {
	String usernamevalue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);//Data Driven approach: reading data from file
	String passwordvalue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
	LoginPage loginPage = new LoginPage(driver);
	loginPage.enterusername(usernamevalue).enterPassword(passwordvalue);//chaining of methods
//	loginPage.enterPassword(passwordvalue);
	//added home =
	home = loginPage.signIn();
	String actual = driver.getCurrentUrl();
	String expected = "https://groceryapp.uniqassosiates.com/admin";
	Assert.assertEquals(actual, expected, Messages.VALID_CREDENTIAL_ASSERT);
	}
@Test(priority = 2, description = "To verify the login using invalid username and valid password")
public void verifyLoginInvalidUsernameValidPassword() throws IOException {
String usernamevalue = ExcelUtility.getStringData(2, 0, Constant.SHEETNAME);
String passwordvalue = ExcelUtility.getStringData(2, 1, Constant.SHEETNAME);
LoginPage loginPage = new LoginPage(driver);
loginPage.enterusername(usernamevalue).enterPassword(passwordvalue).signIn(); 
String actual = driver.getCurrentUrl();
String expected = "https://groceryapp.uniqassosiates.com/admin/login";
Assert.assertEquals(actual, expected, Messages.INVALID_CREDENTIALS_ASSERT);
}
@Test(priority = 3, description = "To verify the login using valid username and invalid password")
public void verifyLoginValidUsernameInvalidPassword() throws IOException {
	String usernamevalue = ExcelUtility.getStringData(3, 0, Constant.SHEETNAME);
	String passwordvalue = ExcelUtility.getStringData(3, 1, Constant.SHEETNAME);
	LoginPage loginPage = new LoginPage(driver);
	loginPage.enterusername(usernamevalue).enterPassword(passwordvalue).signIn();
	//since evrything is in same page
	/*loginPage.enterPassword(passwordvalue);
	loginPage.signIn();*/	
	String actual = driver.getCurrentUrl();
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	Assert.assertEquals(actual, expected, Messages.INVALID_CREDENTIALS_ASSERT);
}
@Test(priority = 4, description = "To verify the login using invalid credentials", dataProvider = "loginProvider")
//Passing string values since data provider contains string data
public void verifyLoginInvalidCredentials(String username, String password) throws IOException {
	/*String usernamevalue = ExcelUtility.getStringData(4, 0, Constant.SHEETNAME);
	String passwordvalue = ExcelUtility.getStringData(4, 1, Constant.SHEETNAME);*/
	LoginPage loginPage = new LoginPage(driver);
	loginPage.enterusername(username).enterPassword(password).signIn();
	String actual = driver.getCurrentUrl();
	String expected = "https://groceryapp.uniqassosiates.com/admin/login";
	Assert.assertEquals(actual, expected, Messages.INVALID_CREDENTIALS_ASSERT);
}
//Data provider:
@DataProvider(name="loginProvider")
//Syntax:
public Object[][] getDataFromDataProvider() throws IOException
{
	return new Object[][] { new Object[] {"user","password"},
		new Object[] {"username","pass"},
		new Object[] {"user","password"}
	};
}
}
