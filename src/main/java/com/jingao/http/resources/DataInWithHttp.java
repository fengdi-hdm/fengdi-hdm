package com.jingao.http.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.jingao.window.data.DataPool;

@Path("datain")
public class DataInWithHttp {
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	public void getSend(String jsonStr) {
		// {"b":"a","f":"kk"}
		String json = "{\"b\":\"a\",\"f\":\"kk\"}";
		String json1 = "{\"b\":\"a\",\"f\":\"kk\",\"d\":\"10\"}";
		String json2 = "{\"b\":\"a\",\"g\":\"g\"}";
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap();
		map = gson.fromJson(json2, HashMap.class);
		System.err.println("comehere :" + jsonStr);
		HashMap<String, Object> newMap = new HashMap<>();
		for (String key : map.keySet()) {
			if (DataPool.FieldTypeMap.get(key) != null) {// 这个字段有映射
				String key1 = DataPool.FieldTypeMap.get(key);//映射字段名
				Object value = map.get(key);//映射字段值
				if (DataPool.fieldValueMap.get(key) != null) {
					if(DataPool.fieldValueMap.get(key).get(value)!=null){
						value = DataPool.fieldValueMap.get(key).get(value);						
					}
				}
				newMap.put(key1, value);
			} else {
				newMap.put(key, map.get(key));
			}
		}
		System.err.println("new map = " + new Gson().toJson(newMap));
	}

//	public static void main(String[] args) {
//		new DataInWithHttp().getSend();
//	}
}
