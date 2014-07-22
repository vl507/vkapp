package com.my.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropConfig {

	public static Properties getProperty(String fileName) {
		Properties properties = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream(fileName);
			properties.load(input);
			return properties;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
