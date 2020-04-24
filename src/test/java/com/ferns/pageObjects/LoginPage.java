package com.ferns.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ferns.driver.WaitDriver;

public class LoginPage extends Page {

	private WebDriver driver;

	@FindBy(css="input#user_email")
	private WebElement email;

	@FindBy(css="input#user_password")
	private WebElement password;

	@FindBy(css="input[value='Log In']")
	private WebElement loginBtn;

	@FindBy(linkText="Forgot Password?")
	private WebElement forgotPassword;

	private LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public static LoginPage getInstance(WebDriver driver) {
		return new LoginPage(driver);

	}

	public LoginPage setEmail(String email) {
		this.email.sendKeys(email);
		return this;
	}

	public LoginPage setPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}

	public void login() {
		this.loginBtn.click();
	}

	@Override
	public boolean isAt() {
		return WaitDriver.getInstance(12).waitForElementVisible(email);
	}

}