package com.stream.driver;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class CommonStudio {
	
	public static AppiumDriver driver;
	
	//@Parameters("platformName")
	@Parameters({"platformName"})
	@BeforeSuite
	public void setCaps(@Optional("Android")String platformName) throws Exception{
		platformName="android";
		if(platformName.equals("android")) {
			 UiAutomator2Options options = new UiAutomator2Options()
			         .setPlatformName("Android")
			         .setDeviceName("emulator-5554")
			         .setAutomationName("UiAutomator2")
			         .setNewCommandTimeout(Duration.ofSeconds(300))
			         .withBrowserName("Chrome");
			            //setChromedriverExecutableDir("C:\\Tools\\chromeDrivers");
			 try {
				 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
				 System.out.println("***********Driver has initiated***********");
		}
			catch (SessionNotCreatedException e2) {
				 System.out.println("############SessionNotCreatedException############");
					}
			 }
		else if(platformName.equals("ios")) {
			XCUITestOptions iosOptions = new XCUITestOptions()
			        .setPlatformName("iOS")
			        .setDeviceName("iPhone 15")
			        .setAutomationName("XCUITest")
			        .withBrowserName("Safari");
			        
			 try {
				 driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), iosOptions);
				 System.out.println("***********Driver has initiated***********");
		}
			catch (SessionNotCreatedException e2) {
				 System.out.println("############SessionNotCreatedException############");
					}
			
		}
		
	}
	
	
	  @BeforeMethod(alwaysRun = true)
	    public void resetBrowser() {
	        try {
	                driver.manage().deleteAllCookies();
	                System.out.println("Broswer rest done before test");
	                driver.get("https://www.wwgoa.com/login");
	                
	                          }
	         catch (Exception e) {
	            System.out.println("Reset not done");
	        }
	    }
	  
	  
	  
	  @AfterSuite(alwaysRun = true)
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("Session closed.");
	        }
	    }

}
