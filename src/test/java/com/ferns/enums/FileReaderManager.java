package com.ferns.enums;

import com.ferns.utilities.ConfigFileReader;

public enum FileReaderManager {
	INSTANCE;

	private ConfigFileReader cfg;

	FileReaderManager() {
		cfg = new ConfigFileReader();
	}

	public ConfigFileReader getConfig() {
		return cfg;
	}

}
