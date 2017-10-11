package com.jingao.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @ClassName: ToolUtil
 * @Description: TODO(根据字母的字典顺序索引)
 * @author Fengdi
 * @date 2017年9月25日
 *
 */
public class ToolUtil {
	public static HashMap<String, Integer> getIndexByName(Set<String> set) {
		// 根据首字母排序
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), i);
		}
		return map;
	}

	/**
	 * 
	 * @Title: mapToArray @Description: TODO(将map转成二维数组,没有顺序) @param @param
	 * map @param @return 参数 @return Object[][] 返回类型 @throws
	 */
	public static Object[][] mapToArray(HashMap<String, String> map) {
		Object[][] o = new Object[map.size()][2];
		int i = 0;
		for (String key : map.keySet()) {
			o[i][0] = key;
			o[i][1] = map.get(key);
		}
		return o;
	}

	public static HashMap<String,String> modelToMap(DefaultTableModel model) {
		HashMap<String,String> map = new HashMap<>();
		for (int row = 0; row < model.getRowCount(); row++) {
			for(int i=0;i<2;i++){
				map.put((String)model.getValueAt(row, 0), (String)model.getValueAt(row, 1));
			}
		}
		return map;
	}
}