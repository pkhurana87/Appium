package AppiumProject.Selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public AppiumDriver driver;
	@BeforeMethod
	@BeforeClass
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("deviceName", "Pixel_Emulator");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", ".Calculator");
	    desiredCapabilities.setCapability("udid","emulator-5554");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }
	
	
	
	@Test
	public void test() {
		driver.findElementById("digit_8").click();
		driver.findElementById("op_mul").click();
		driver.findElementById("digit_2").click();
		
		AssertJUnit.assertEquals(driver.findElementById("result").getText(), "16");
		System.out.println("Tested");
		
		
		
		
		
		
	}
	
	
	@AfterMethod
	@AfterClass
	public void tearDown()
	{

	   if (driver != null)
	      driver.quit();
	    
	}
}
