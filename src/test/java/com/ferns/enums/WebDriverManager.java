package com.ferns.enums;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum WebDriverManager {
	INSTANCE;

	private WebDriver driver;

	WebDriverManager() {
		FileReaderManager fr = FileReaderManager.INSTANCE;
		DriverType dt = fr.getConfig().getBrowserType();
		switch (dt) {
		case INTERNETEXPLORER:
			System.setProperty("webdriver.ie.driver", fr.getConfig().getDriverPath() + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", fr.getConfig().getDriverPath() + "geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", fr.getConfig().getDriverPath() + "chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(fr.getConfig().getImplicitWaitTime(), TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}
}
