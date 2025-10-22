package appiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {

	public static void main(String[] args)throws MalformedURLException {
		// TODO Auto-generated method stub
//		
//		DesiredCapabilities caps=new DesiredCapabilities();
//		
//		 caps.setCapability("platformName", "Android");          // W3C standard
//		 caps.setCapability("appium:deviceName", "Android device");  // namespaced!
//		 caps.setBrowserName("Chrome");
//		 caps.setCapability("appium:automationName", "UiAutomator2");
//		 caps.setCapability("appium:noReset", true);       // don't reset app state
//		 caps.setCapability("appium:fullReset", false); 
//		 @SuppressWarnings("deprecation")
//		AndroidDriver driver=new AndroidDriver (new URL("http://192.168.1.189:4723/"),caps);
//		 WebDriverManager.chromedriver().setup();
//		 System.out.println("Driver has intiated");
//		// driver.get("https://www.google.com");

        UiAutomator2Options options = new UiAutomator2Options()
            .setPlatformName("Android")
            .setDeviceName("emulator-5554")
            .setAutomationName("UiAutomator2")
            .setNewCommandTimeout(Duration.ofSeconds(300))
            .withBrowserName("Chrome");
            //setChromedriverExecutableDir("C:\\Tools\\chromeDrivers");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        System.out.println("Driver initiated succesfully");
        driver.get("https://www.wwgoa.com/login");
        WebElement el=driver.findElement(By.xpath("//p[contains(text(),'Enter your sign in info below')]"));
        boolean isDisplayed=el.isDisplayed();
        Assert.assertEquals(isDisplayed, true);
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tester1@simplestream.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("TestLogin");
        driver.findElement(By.cssSelector("button[aria-label='Sign in']")).click();
        WebElement el1=driver.findElement(By.xpath("//a[contains(text(),'My Content')]"));
        boolean isDisplayed2=el1.isDisplayed();
        Assert.assertEquals(isDisplayed2, true);
        
		

      

	}

}
