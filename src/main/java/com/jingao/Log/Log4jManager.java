package com.jingao.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import com.jingao.base.Operator;

public class Log4jManager implements Operator {

	public void init() throws Exception {
		setLogConfigFilePath();
	}

	private static String setLogConfigFilePath() {
		ConfigurationSource source;
		String config = System.getProperty("user.dir");
		String fullPath = config + "/conf/log4j2.xml";
		System.out.println("Log4j2 fullPath = " + fullPath);
		File file = new File(fullPath);
		try {
			source = new ConfigurationSource(new FileInputStream(file), file);
			Configurator.initialize(null, source);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fullPath;
	}

}
