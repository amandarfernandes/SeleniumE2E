package com.ferns.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.ferns.enums.DriverType;

public class ConfigFileReader {
	private Properties config;
	private String resourcePath = System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\";
	
	private ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(resourcePath+"config.properties"));
			config = new Properties();
			try {
				config.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config file not found at "+resourcePath);
		}		
	}
	
	public static ConfigFileReader getInstance() {
		return new ConfigFileReader();
	}
	
	public DriverType getBrowserType() {
		String browser = config.getProperty("browser").toLowerCase();
		DriverType dt;
		switch (browser) {
		case "ie":
			dt=DriverType.INTERNETEXPLORER;
			break;
		case "firefox":
			dt=DriverType.FIREFOX;
			break;
		default:
			dt=DriverType.CHROME;
		}		
		return dt;
	}
	
	public String getDriverPath() {
		return config.getProperty("driverPath");
	}
	
	public int getWaitTime() {
		return Integer.parseInt(config.getProperty("wait"));
	}
	
	public String getSite() {
		return config.getProperty("url");
	}
}
