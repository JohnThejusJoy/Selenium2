package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	WaitUtility waitUtility = new WaitUtility();
	PageUtility pageUtility = new PageUtility();
	public WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@FindBy(xpath = "//a[@data-toggle='dropdown']") WebElement adminbtn;
public AdminPage adminButton() {
	waitUtility.waitUntilClickable(driver, adminbtn);
pageUtility.clickOnElement(adminbtn);
return new AdminPage(driver);
}
@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']") WebElement logoutbtn;
public LoginPage logOut() {
	waitUtility.waitUntilClickable(driver, logoutbtn);
	pageUtility.clickOnElement(logoutbtn);
	return new LoginPage(driver);
}
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement manageadmininfo;
public AdminPage adminInfo() {
	pageUtility.clickOnElement(manageadmininfo);
	return new AdminPage(driver);
}
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement managenewsbtn;
public NewsPage manageNews() {
	pageUtility.clickOnElement(managenewsbtn);
	return new NewsPage(driver);
}
//chaning void to adminpage
}
