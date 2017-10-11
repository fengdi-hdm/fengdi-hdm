package com.jingao.Config;

import java.io.File;
import java.util.HashMap;

import com.jingao.Log.LogUtil;
import com.jingao.base.Operator;
import com.jingao.util.PropertiesReader;
/**
 * 
    * @ClassName: ConfigManager
    * @Description: TODO(提供配置文件初始化)
    * @author Administrator
    * @date 2017年8月18日
    *
 */
public class ConfigManager implements Operator {

	public static String BASEDIR = "conf/";
	public void init() throws Exception{
		String[] files = getConfigFileName();
		if (files == null) {
			return;
		}
		for (int i = 0; i < files.length; i++) {
			if (!files[i].contains("properties")) {
				continue;
			}
			LogUtil.log.info(files[i]);
			HashMap<String, String> properties = PropertiesReader.readProperties(BASEDIR+files[i]);
			String name = files[i].substring(0, files[i].lastIndexOf("."));
			ConfigDataPool.put(name, properties);
			LogUtil.log.info("put = "+ files[i]);
		}

	}

	private String[] getConfigFileName() {
		File file = new File(BASEDIR);
		if (file.exists()) {
			System.err.println("OK");
			if (!file.isDirectory()) {
				return null;
			}
			return file.list();
		} else {
			System.err.println("ON");
		}
		return null;
	}

}
