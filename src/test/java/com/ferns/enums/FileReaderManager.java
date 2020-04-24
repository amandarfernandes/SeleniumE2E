package com.ferns.enums;

import com.ferns.utilities.ConfigFileReader;

public enum FileReaderManager {
	INSTANCE;

	private ConfigFileReader cfg;

	private FileReaderManager() {
		cfg = ConfigFileReader.getInstance();
	}

	public ConfigFileReader getConfig() {
		return cfg;
	}

}
