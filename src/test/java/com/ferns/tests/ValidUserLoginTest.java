package com.ferns.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ferns.enums.DriverManager;
import com.ferns.pageObjects.HomePage;
import com.ferns.pageObjects.LoginPage;
import com.ferns.pageObjects.UserHomePage;

public class ValidUserLoginTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeTest
	public void setUp() {
		driver = DriverManager.INSTANCE.getDriver();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test (priority=1)
	public void launch() {
		homePage = HomePage.getInstance(driver).goTo();

		//validate if the page is loaded
	    Assert.assertTrue("The site did not load successfully",homePage.isAt(10)); 
	}
	
	@Test(dependsOnMethods="launch")
	public void goToLogin() {
		homePage.goToLogin();	
		loginPage = LoginPage.getInstance(driver);
		
		//validate if the page is loaded
		Assert.assertTrue(loginPage.isAt());		
	}
	
	@Test (dependsOnMethods="goToLogin", dataProvider="getUserData")
	public void loginTest(String email, String password) {
		loginPage.setEmail(email)
					.setPassword(password)
					.login();
		Assert.assertTrue("User not directed to User Home Page",  UserHomePage.getInstance(driver).isAt(10));
	}
	
	@DataProvider
	private Object[][] getUserData() {
		return new Object [][] {
			{"dcunhaa@yahoo.com","amanda23"}
		};
	}
}
