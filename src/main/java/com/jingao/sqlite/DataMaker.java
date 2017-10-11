package com.jingao.sqlite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.jingao.Config.ConfigDataPool;
import com.jingao.Log.LogUtil;

public class DataMaker {
	public Object[][] getFiledConfigModel(String sql) throws Exception {
		List<HashMap<String, Object>> list = SqliteManager.select("select count(*) count from fieldconfig");
		int count = (int) list.get(0).get("count");
		List<List<Object>> lo = SqliteManager.listSelect(sql);
		if (lo == null) {
			return null;
		}
		Object[][] o = new Object[lo.size()][lo.get(0).size()];

		for (int j = 0; j < lo.size(); j++) {
			for (int i = 0; i < lo.get(j).size(); i++) {
				if (lo.get(i) == null) {
					continue;
				}
				o[j][i] = lo.get(j).get(i).toString();

			}
		}
		return o;
	}

	/**
	 * 
	 * @Title: getConfigModel @Description:
	 * TODO(获得配置文件内容的tablemodel) @param @param configName @param @return
	 * 参数 @return DefaultTableModel 返回类型 @throws
	 */
	public DefaultTableModel getConfigModel(String configName) {
		HashMap<String, String> data = ConfigDataPool.config(configName);
		Object[][] dataArr = new Object[data.size() + 1][2];
		int j = 0;
		for (String key : data.keySet()) {
			dataArr[j][0] = key;
			dataArr[j][1] = data.get(key);
			j++;
		}
		DefaultTableModel t = new DefaultTableModel(dataArr, new String[] { "key", "value" });
		return t;
	}
	
	/**
	 * 
	    * @Title: getFieldValueModel
	    * @Description: TODO(获取字段映射的tablemodel)
	    * @param @param fieldName
	    * @param @return    参数
	    * @return DefaultTableModel    返回类型
	    * @throws
	 */

	public DefaultTableModel getFieldValueModel(String fieldName) {
		List<HashMap<String, Object>> list = null;
		try {
			list = SqliteManager.select("select * from "+fieldName+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LogUtil.log.info("no table "+fieldName);
			return null;
		}
		Object[][] o = new Object[list.size()][2];
		int i=0;
		for(HashMap<String,Object> record:list){
			o[i][0] = record.get("come");
			o[i][1] = record.get("out");
		}
		DefaultTableModel model = new DefaultTableModel(o,new String[]{"come","out"});
		return model;
	}
}
