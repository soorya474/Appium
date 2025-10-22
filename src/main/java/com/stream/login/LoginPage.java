package com.stream.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class LoginPage {
	
	
	public WebElement element;
	
	public WebElement usernameTxtBox(AppiumDriver driver) {
		element = driver.findElement(By.cssSelector("input[name='username']"));//.sendKeys("tester1@simplestream.com");
		return element;
}
	
	public WebElement passwordTxtBox(AppiumDriver driver) {
		element = driver.findElement(By.cssSelector("input[name='password']"));//.sendKeys("tester1@simplestream.com");
		return element;
}
	public WebElement signInButton(AppiumDriver driver) {
		element = driver.findElement(By.cssSelector("button[aria-label='Sign in']"));//.sendKeys("tester1@simplestream.com");
		return element;
}
	
	public WebElement signInText(AppiumDriver driver) {
		element = driver.findElement(By.xpath("//p[contains(text(),'Enter your sign in info below')]"));
		return element;
}
	
	public WebElement HomePageText(AppiumDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'My Content')]"));
		return element;
}
	
	
	
	
	
	
	

}
