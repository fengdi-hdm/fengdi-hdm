package com.jingao.sqlite;

import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

public class SqlMaker {
	/**
	 * 
	    * @Title: CreateFieldConfigTable
	    * @Description: TODO(创建)
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public String CreateFieldConfigTable(){
		StringBuilder sql = new StringBuilder();
		sql.append("create table fieldconfig(")
		.append("name varchar(32),")
		.append("type varchar(32),")
		.append("jiraname varchar(32),")
		.append("jiratype varchar(32))");
		return sql.toString();
	}
	/**
	 * 
	    * @Title: CreateFieldMapping
	    * @Description: TODO(创建字段值域映射)
	    * @param @param fieldName
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public String CreateFieldMapping(String fieldName){
		StringBuilder sql = new StringBuilder();
		sql.append("create table ").append(fieldName).append("(")
		.append("come varchar(32),")
		.append("out varchar(32))");
		return sql.toString();
	}
	
	public String UpdateFieldMapping(DefaultTableModel dt,String fieldName){
		StringBuilder sql = new StringBuilder();
		sql.append("delete from "+fieldName+";");
		sql.append(makeInsert(dt,fieldName));	
		return sql.toString();
	}
	
	
	/**
	 * 
	    * @Title: makeInsert
	    * @Description: TODO(生成插入语句)
	    * @param @param dt
	    * @param @param tableName
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public String makeInsert(DefaultTableModel dt,String tableName){
		StringBuffer sql = new StringBuffer();
		for(int i=0;i<dt.getRowCount();i++){
			sql.append("insert into ").append(tableName).append(" values(");
			for(int j=0;j<dt.getColumnCount();j++){
				sql.append("'").append(dt.getValueAt(i, j)).append("',");
			}
			sql = sql.delete(sql.lastIndexOf(","), sql.length());
			sql.append(");");
		}
		System.out.println(sql.toString());
		return sql.toString();
	}
	
	public void makeUpdate(){}
}
