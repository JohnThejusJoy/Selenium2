package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	WaitUtility waitUtility = new WaitUtility();
	PageUtility pageUtility = new PageUtility();
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
	this.driver = driver;	
	//Initializing PF
	PageFactory.initElements(driver, this);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//syntax
	}
	//Implementing PF
	@FindBy(xpath = "//input[@name='username']") WebElement username;
public LoginPage enterusername(String usernamevalue) {
	//chain void oto Loginpage
	//username.sendKeys(usernamevalue);
	pageUtility.sendDataToElement(username, usernamevalue);
	return this;
}
@FindBy(xpath = "//input[@name='password']") WebElement password;
public LoginPage enterPassword(String passwordvalue) {
pageUtility.sendDataToElement(password, passwordvalue);
return this;
}
@FindBy(xpath = "//button[@type='submit']") WebElement signin;
//since signin navigates to homepagge
public HomePage signIn() {
waitUtility.waitUntilClickable(driver, signin);	
pageUtility.clickOnElement(signin);
return new HomePage(driver);//since homepage is a parametereised constructor, object initialisation
}
//Page Factory: Design pattern to avoid repetition
//all others within loginpage, signin navigatesto homepage
//chaining of classes
}