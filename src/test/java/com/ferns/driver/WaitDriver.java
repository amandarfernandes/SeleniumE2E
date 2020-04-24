package com.ferns.driver;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ferns.enums.DriverManager;

public class WaitDriver {
	
	private WebDriverWait waitDriver;


	private WaitDriver(int time) {
		waitDriver = new WebDriverWait(DriverManager.INSTANCE.getDriver(), time);		
	}
	
	public static WaitDriver getInstance(int time) {
		return new WaitDriver(time);
	}
	
	public boolean waitForElementVisible(WebElement element) {
		try {
			waitDriver.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean waitForElementClickable(WebElement element) {
		try {
			waitDriver.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e) {
			return false;
		}
		return true;
	}
}
