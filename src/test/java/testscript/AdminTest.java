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
import utilities.FakerUtility;

public class AdminTest extends TestNGBase{
	public HomePage homePage;
	public AdminPage adminPage;
@Test(description = "To create an Admin user")
public void createAdmin() throws IOException{
	String usernamevalue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);//Data Driven approach: reading data from file
	String passwordvalue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
	LoginPage loginPage = new LoginPage(driver);
	loginPage.enterusername(usernamevalue).enterPassword(passwordvalue);
	//loginPage.enterPassword(passwordvalue);
	homePage = loginPage.signIn();
	//removing AdminPage adminPage = new AdminPage(driver);
	adminPage = homePage.adminInfo();//instead of adminPage.adminInfo();
	FakerUtility fakerUtility = new FakerUtility();
	String randomusername = fakerUtility.createRandomUserName();
	String randompassword = fakerUtility.createRandomPassword();
	adminPage.newAdmin().adminUsername(randomusername).adminPassword(randompassword).adminDropdown().adminSave();
	/*adminPage.adminUsername(randomusername);
	adminPage.adminPassword(randompassword);
	adminPage.adminDropdown();
	adminPage.adminSave();*/
	boolean isAlertDisplayed = adminPage.isAlertDisplayed();
	Assert.assertTrue(isAlertDisplayed, Messages.CREATE_ADMIN_ASSERT);
}
}
