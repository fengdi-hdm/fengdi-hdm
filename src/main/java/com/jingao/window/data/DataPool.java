package com.jingao.window.data;

import java.util.HashMap;
import java.util.HashSet;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @ClassName: DataPool
 * @Description: TODO(缓存数据)
 * @author Fengdi
 * @date 2017年8月24日
 *
 */
public class DataPool {
	// 缓存打开的页面
	public static HashSet<String> framSet = new HashSet<>();

	// 缓存对接字段类型
	public static HashMap<String, String> FieldTypeMap = new HashMap<>();
	
	//缓存对接字段类型model
	public static DefaultTableModel fieldTypeModel = null;

	// 缓存数据映射数据,key字段名,value字段映射表

	public static HashMap<String, DefaultTableModel> fieldValueModel = new HashMap<>();
	
	public static HashMap<String,HashMap<String,String>> fieldValueMap = new HashMap<>();
	
	

}
