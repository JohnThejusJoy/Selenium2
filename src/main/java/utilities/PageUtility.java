package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;

public class PageUtility {
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void sendDataToElement(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	public void scrollToElement(WebDriver driver, WebElement element) {
	    Actions actions=new Actions(driver);
	    actions.moveToElement(element).perform();
	}

	public void javaScriptClick(WebDriver driver, By locator) {
	    WebElement element = driver.findElement(locator);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	
	public void clearElementData(WebElement element) {
		element.clear();
	}
	public void selectData(WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(Constant.ADMINNAME);
	}
	public boolean alertDisplay(WebElement element) {
		return element.isDisplayed();
	}
}
