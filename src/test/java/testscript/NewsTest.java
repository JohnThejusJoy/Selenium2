package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Constant;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNGBase{
	public HomePage homePage;
	public NewsPage newsPage;
	@Test(description = "Test case for news addition", groups = {"smoke"})
	public void addNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);//Data Driven approach: reading data from file
		String passwordvalue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusername(usernamevalue).enterPassword(passwordvalue);
		homePage = loginPage.signIn();
		newsPage = homePage.manageNews();
		newsPage.newNews().newsText().saveNews();
		boolean isalertDisplayed = newsPage.isAlertDisplayed();
		Assert.assertTrue(isalertDisplayed, Messages.ADD_NEWS_ASSERT);
	}
	@Test(description = "Test case for news search")
public void searchNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);//Data Driven approach: reading data from file
		String passwordvalue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusername(usernamevalue).enterPassword(passwordvalue);
		homePage = loginPage.signIn();
		newsPage = homePage.manageNews();
		newsPage.searchNews().searchText().searchButton();
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/news/index";
		Assert.assertEquals(actual, expected, Messages.SEARCH_NEWS_ASSERT);
	}
	@Test(description = "Return to home")
public void returntoHome() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);//Data Driven approach: reading data from file
		String passwordvalue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusername(usernamevalue).enterPassword(passwordvalue);
		homePage = loginPage.signIn();
		newsPage = homePage.manageNews();
		homePage = newsPage.returntoHome();
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/home";
		Assert.assertEquals(actual, expected, Messages.RETURN_TO_HOME_ASSERT);
	}
	@Test(description = "Reset")
	public void reset() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, Constant.SHEETNAME);//Data Driven approach: reading data from file
		String passwordvalue = ExcelUtility.getStringData(1, 1, Constant.SHEETNAME);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusername(usernamevalue).enterPassword(passwordvalue);
		homePage = loginPage.signIn();
		newsPage = homePage.manageNews();
		newsPage.resetButton();
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/list-news";
		Assert.assertEquals(actual, expected, Messages.RESET_ASSERT);
	}

}
