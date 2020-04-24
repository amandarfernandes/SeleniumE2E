package com.ferns.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ferns.driver.WaitDriver;
import com.ferns.enums.FileReaderManager;


public class HomePage extends Page{
	private WebDriver driver;
	
	@FindBy(css=".login-btn:nth-of-type(2) a")
	private WebElement loginLink;
	
	//Default private constructor will ensure no unplanned construction of class
	private HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	
	//Factory method to store object creation logic in single place
	public static  HomePage getInstance(WebDriver driver) {
		return new HomePage(driver);
	}
	
	public void goToLogin() {
		this.loginLink.click();
	}

	@Override
	public boolean isAt (int timeOut) {
		return WaitDriver.getInstance(10).waitForElementClickable(loginLink);
	}
	
	public HomePage goTo() {
		driver.get(FileReaderManager.INSTANCE.getConfig().getSite());
		return this;
	}	
}