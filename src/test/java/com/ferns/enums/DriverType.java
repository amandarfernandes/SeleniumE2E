package com.ferns.enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum DriverType {
	FIREFOX {
		@Override
		public WebDriver setUp() {
			System.setProperty("webdriver.gecko.driver",
					FileReaderManager.INSTANCE.getConfig().getDriverPath() + "geckodriver.exe");
			return new FirefoxDriver();
		}
	},
	CHROME {
		@Override
		public WebDriver setUp() {
			System.setProperty("webdriver.chrome.driver",
					FileReaderManager.INSTANCE.getConfig().getDriverPath() + "chromedriver.exe");
			return new ChromeDriver();
		}
	},
	INTERNETEXPLORER {
		@Override
		public WebDriver setUp() {
			System.setProperty("webdriver.ie.driver",
					FileReaderManager.INSTANCE.getConfig().getDriverPath() + "IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
	};

	public abstract WebDriver setUp();
}
