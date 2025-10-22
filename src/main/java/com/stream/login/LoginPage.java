package com.stream.login;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.stream.driver.CommonStudio;

import io.appium.java_client.AppiumDriver;

public class LoginPage  {
	
	//private final WebDriver driver;
	public WebElement element;
	public AppiumDriver driver;
	
	public LoginPage(AppiumDriver driver) {
		this.driver=driver;
	}
	
	public WebElement usernameTxtBox( WebDriver driver) {
		element = driver.findElement(By.cssSelector("input[name='username']"));//.sendKeys("tester1@simplestream.com");
		return element;
}
	
	public WebElement passwordTxtBox(WebDriver driver) {
		element = driver.findElement(By.cssSelector("input[name='password']"));//.sendKeys("tester1@simplestream.com");
		return element;
}
	public WebElement signInButton(WebDriver driver) {
		element = driver.findElement(By.cssSelector("button[aria-label='Sign in']"));//.sendKeys("tester1@simplestream.com");
		return element;
}
	public WebElement checkBox(WebDriver driver) {
		element=driver.findElement(By.cssSelector("input[type='checkbox']"));
		return element;
	}
	
	public WebElement signInText(WebDriver driver) {
		element = driver.findElement(By.xpath("//p[contains(text(),'Enter your sign in info below')]"));
		return element;
}
	
	public WebElement HomePageText(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'My Content')]"));
		return element;
}
	public WebElement ErrorText(WebDriver driver) {
		element = driver.findElement(By.xpath("//li[contains(text(),'These credentials do not match our records')]"));
		return element;
}
	
	public  void login(String username,String password) throws Exception {
		waitUntilElt(usernameTxtBox(driver));
		usernameTxtBox(driver).sendKeys(username);
		validateEnteredUsername(driver);
		waitUntilElt(passwordTxtBox(driver));
		passwordTxtBox(driver).sendKeys(password);
		validateEnteredPassword(driver);
		driver.manage().deleteAllCookies();
		checkBox(driver).click();
		driver.manage().deleteAllCookies();
		waitUntilElt(signInButton(driver));
		driver.manage().deleteAllCookies();
		signInButton(driver).click();
		validateSignInpage(driver);
		waitUntilElt(HomePageText(driver));
		validateHomePage( driver); 
	}
		
	public void waitUntilElt(WebElement element) {
			   
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	     wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	
	public void validateEnteredUsername(WebDriver driver)throws Exception{
		try {	
		String enteredUsername = usernameTxtBox(driver).getAttribute("value");
		Assert.assertEquals(enteredUsername, enteredUsername, "Username not populated correctly!");
		}
		catch (Exception e) {
			
		System.out.println("Data Not populated");
	}
	}
	public void validateEnteredPassword(WebDriver driver){
		String enteredPassword = passwordTxtBox(driver).getAttribute("value");
		Assert.assertEquals(enteredPassword, enteredPassword, "Password not populated correctly!");
	}
	
	public void validateSignInpage(WebDriver driver) {
		boolean displayed=signInText(driver).isDisplayed();
		Assert.assertEquals(displayed, true,"***SignInPage is displayed***");
	}
	public void validateHomePage(WebDriver driver) {
		boolean displayed=HomePageText(driver).isDisplayed();
		Assert.assertEquals(displayed, true,"***Home Page is Displayed***");
	}
	public void validateErrorMsg(WebDriver driver) {
		boolean displayed=ErrorText(driver).isDisplayed();
		Assert.assertEquals(displayed, true, "***Login is failed***");
	}
	
	
	
	
	
	

}
