package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	WaitUtility waitUtility = new WaitUtility();
	PageUtility pageUtility = new PageUtility();
public WebDriver driver;
public AdminPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
//remmoving admininfo to home since its in home

@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newadmin;
public AdminPage newAdmin() {
	waitUtility.waitUntilClickable(driver, newadmin);
pageUtility.clickOnElement(newadmin);
return this;
}
@FindBy(xpath = "//input[@type='text' and @class='form-control' and @id='username']") WebElement adminusername;
public AdminPage adminUsername(String username) {
	pageUtility.sendDataToElement(adminusername, username);
	return this;
}
@FindBy(xpath = "//input[@type='password' and @class='form-control' and @id='password']") WebElement adminpassword;
public AdminPage adminPassword(String password) {
	pageUtility.sendDataToElement(adminpassword, password);
	return this;
}
@FindBy(xpath = "//select[@class='form-control' and @id='user_type']") WebElement dropdown;
public AdminPage adminDropdown() {
	pageUtility.selectData(dropdown);
	return this;
}
@FindBy(xpath = "//button[@type='submit' and @class='btn btn-block-sm btn-danger' and @name='Create']") WebElement savebtn;
public AdminPage adminSave() {
pageUtility.clickOnElement(savebtn);
return this;
}
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alert;
public boolean isAlertDisplayed() {
	return pageUtility.alertDisplay(alert);
}
}
