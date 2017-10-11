package com.jingao.DB;

import java.util.HashMap;
import java.util.List;

import com.jingao.DB.beans.Two;

public class DBUtil {
	/**
	 * 
	    * @Title: DBListToMap
	    * @Description: TODO(将查出键值类型的对象封装到hashmap,key不能重复)
	    * @param @param two
	    * @param @return    参数
	    * @return HashMap<String,String>    返回类型
	    * @throws
	 */
	public static HashMap<String,String> DBListToMap(List<Two> two){
		HashMap<String,String> map = new HashMap<String, String>();
		for(Two t:two){
			map.put(t.getKey(), t.getValue());
		}
		return map;
	}
}
