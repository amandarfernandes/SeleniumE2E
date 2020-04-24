package com.ferns.enums;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public enum DriverManager {
	INSTANCE;

	private WebDriver driver;

	private DriverManager() {
		DriverType dt = FileReaderManager.INSTANCE.getConfig().getBrowserType();
		driver = dt.setUp();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

	
	public void quitDriver() {
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

