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
		element = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
		return element;
}
	public WebElement ErrorText(WebDriver driver) {
		element = driver.findElement(By.xpath("//li[contains(text(),'These credentials do not match our records')]"));
		return element;
}
	public WebElement popupBtn(WebDriver driver) {
		element=driver.findElement(By.cssSelector("button[aria-label='Accept the consent disclosure.']"));
		return element;
	}
	
	public  void login(String username,String password,boolean result) throws Exception {
		validateSignInpage(driver);
		waitUntilElt(usernameTxtBox(driver));
		usernameTxtBox(driver).sendKeys(username);
		validateEnteredUsername(driver);
		waitUntilElt(passwordTxtBox(driver));
		passwordTxtBox(driver).sendKeys(password);
		validateEnteredPassword(driver);
		driver.manage().deleteAllCookies();
		popupBtn(driver).click();
		checkBox(driver).click();
		driver.manage().deleteAllCookies();
		waitUntilElt(signInButton(driver));
		driver.manage().deleteAllCookies();
		signInButton(driver).click();
		waitUntilElt(HomePageText(driver));
		validateHomePage( driver,result); 
	}
	/**
	 * 
	 * @param element
	 */
		
	public void waitUntilElt(WebElement element) {
			   
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	     wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	/**
	 * 
	 * @param driver
	 * @throws Exception
	 * Validates username  entered is populated or not
	 */
	
	public void validateEnteredUsername(WebDriver driver)throws Exception{
		try {	
		String enteredUsername = usernameTxtBox(driver).getAttribute("value");
		Assert.assertEquals(enteredUsername, enteredUsername, "Username not populated correctly!");
		System.out.println("Username is populted");
		}
		catch (Exception e) {
			
		System.out.println("Data Not populated");
	}
	}
	
	/**
	 * 
	 * @param driver
	 * Validates password entered is populated or not
	 */
	public void validateEnteredPassword(WebDriver driver){
		String enteredPassword = passwordTxtBox(driver).getAttribute("value");
		Assert.assertEquals(enteredPassword, enteredPassword, "Password not populated correctly!");
	}
	/**
	 * 
	 * @param driver
	 * Validates Signin Page is Displayed or not
	 */
	
	public void validateSignInpage(WebDriver driver) throws Exception{
		Thread.sleep(10000);
		boolean displayed=signInText(driver).isDisplayed();
		Assert.assertEquals(displayed, true,"***SignInPage is displayed***");
	}
//	public void validateHomePage(WebDriver driver) {
//		boolean displayed=HomePageText(driver).isDisplayed();
//		Assert.assertEquals(displayed, true,"***Home Page is Displayed***");
//	}
	/**
	 * 
	 * @param driver
	 * Validates Home Page
	 */
	public void validateHomePage(WebDriver driver,boolean actual) {
		if(actual) {
			boolean displayed=HomePageText(driver).isDisplayed();
			Assert.assertTrue(displayed,"***Home Page is Displayed***");
			System.out.println("Login done");
		}
		else {
			boolean displayed=ErrorText(driver).isDisplayed();
			Assert.assertTrue(displayed, "***Login is  not succesful***");
			System.out.println("Login not done");
			
		}
	}
	
	
	
	
	
	

}
