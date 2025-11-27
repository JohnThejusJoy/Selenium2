package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Constant;
import constants.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase{
	public AdminPage adminPage;
	public HomePage home;
	@Test(priority = 1, description = "Logout function")
	public void verifyLogout() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);//Data Driven approach: reading data from file
		String passwordvalue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusername(usernamevalue).enterPassword(passwordvalue);
		home = loginPage.signIn();
		HomePage homePage = new HomePage(driver);
		adminPage = homePage.adminButton();
		loginPage = homePage.logOut();
		String current = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		Assert.assertEquals(current, expected, Messages.LOGOUT_ASSERT);
		}
}
