package com.stream.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class Helpers {

	public static AppiumDriver driver;

	public static void waitUntilElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void verifyWhenElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		element.isDisplayed();

	}

}
