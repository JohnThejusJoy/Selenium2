package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class NewsPage {
	WaitUtility waitUtility = new WaitUtility();
	PageUtility pageUtility = new PageUtility();
public WebDriver driver;
public NewsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newnewsbtn;
public NewsPage newNews()
{
	pageUtility.clickOnElement(newnewsbtn);
	return this;
}
@FindBy(xpath = "//textarea[@id='news']") WebElement newstxt;
public NewsPage newsText()
{
	pageUtility.sendDataToElement(newstxt, "Breaking");
	return this;
}
@FindBy(xpath = "//button[@type='submit']") WebElement savebtn;
public NewsPage saveNews()
{
	pageUtility.clickOnElement(savebtn);
	return this;
}
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchbtn;
public NewsPage searchButton()
{
		waitUtility.waitUntilClickable(driver, searchbtn);
	pageUtility.clickOnElement(searchbtn);
	return this;
}
@FindBy(xpath = "//input[@class='form-control']") WebElement searchfield;
public NewsPage searchText() {
	pageUtility.sendDataToElement(searchfield, "Breaking");
	return this;
}
@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement searchnewsbtn;
public NewsPage searchNews()
{
	pageUtility.clickOnElement(searchnewsbtn);
	return this;
}
@FindBy(xpath = "//a[text()='Home']") WebElement homebtn;
public HomePage returntoHome()
{
	pageUtility.clickOnElement(homebtn);
	return new HomePage(driver);
}
@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement resetbtn;
public NewsPage resetButton()
{
	pageUtility.clickOnElement(resetbtn);
	return this;
}
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alert;
public boolean isAlertDisplayed() {
	return pageUtility.alertDisplay(alert);
}
}
