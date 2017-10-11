package com.jingao.util;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesReader {
	public static String PATH = "../conf/config.properties";
	public static String readValue(String filePath, String key) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			props.load(in);
			String value = props.getProperty(key);
			//System.out.println(key + value);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//读取配置到一个hashMap
	public static HashMap<String,String> readProperties(String filePath) {
		Properties props = new Properties();
		HashMap<String,String> config = new HashMap<String, String>();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			props.load(in);
			Enumeration<?> en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String Property = props.getProperty(key);
				config.put(key, Property);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return config;
	}
}
