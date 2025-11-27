package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	//syntax
	
	public void getScreenshot(WebDriver driver,String failedTestCase) throws IOException
	{
	//TakesScreenshot: Predefined class
	TakesScreenshot scrShot = (TakesScreenshot) driver;//typecasting to driver
	//Saves as file
	File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
	
	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");//create folder in  directory
	if (!f1.exists()) {
	//Java file handling method to create a folder
	f1.mkdirs();
	}
	String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
	+ ".png";
	//create file
	File finalDestination = new File(destination);
	//copy: built-in fn 
	FileHandler.copy(screenShot, finalDestination);
	}
}
