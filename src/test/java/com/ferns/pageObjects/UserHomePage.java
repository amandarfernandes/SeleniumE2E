package com.ferns.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ferns.driver.WaitDriver;

public class UserHomePage extends Page {
	private WebDriver driver;
	
	@FindBy(css=".navbar-current-user")
	private WebElement currentUser;
	
	private UserHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public static UserHomePage getInstance(WebDriver driver) {
		return new UserHomePage(driver);
	}
	
	public boolean isAt(int time) {
		try {
			WaitDriver.getInstance(time).waitForElementVisible(currentUser);
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}
	
	
}
