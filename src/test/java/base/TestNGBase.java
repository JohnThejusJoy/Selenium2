package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;

public class TestNGBase {
	Properties prop;//Declaring Properties class as a global var
	FileInputStream f;
	public WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initialiseBrowser(String browser) throws Exception{
		prop = new Properties();
		f= new FileInputStream(Constant.CONFIGFILE);
		prop.load(f);//load any file with .properties
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();//Change settings within Chrome
			Map<String,Object> prefs=new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(options);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser() {
	//	driver.close();//tab
	//	driver.quit();//window
	}
	@AfterMethod(alwaysRun = true)//alwaysRun = true: @AfterMethod must run in every scenario
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
		//ITestResult: predefined interface having all info regarding test data
		if(iTestResult.getStatus()==ITestResult.FAILURE)
		{
			ScreenshotUtility screenShot=new ScreenshotUtility();
			//iTestResult.getName: Returns name of test method
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();
	}
}
