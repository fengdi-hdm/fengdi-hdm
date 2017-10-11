package com.jingao.Config;

import java.util.HashMap;

/**
 * 
    * @ClassName: ConfigDataPool
    * @Description: TODO(启动时扫描conf目录下所有的properties文件,将数据缓存到不同的变量)
    * @author Administrator
    * @date 2017年8月10日
    *
 */
public class ConfigDataPool {
	
	public static HashMap<String,HashMap<String,String>> config = new HashMap<String, HashMap<String,String>>();
	
	/**
	 * 
	    * @Title: config
	    * @Description: TODO(根据名字获得config)
	    * @param @param name
	    * @param @return    参数
	    * @return HashMap<String,String>    返回类型
	    * @throws
	 */
	public static HashMap<String,String> config(String name){
		return config.get(name);
	}
	
	/**
	 * 
	    * @Title: add
	    * @Description: TODO(添加或更新一个config)
	    * @param @param name
	    * @param @param newconfig    参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void put(String name,HashMap<String,String> newconfig){
		config.put(name, newconfig);
	}
	
	/**
	 * 
	    * @Title: remove
	    * @Description: TODO(移除指定名字config)
	    * @param @param name    参数
	    * @return void    返回类型
	    * @throws
	 */
	private static void remove(String name){
		config.remove(name);
	} 
	
}
