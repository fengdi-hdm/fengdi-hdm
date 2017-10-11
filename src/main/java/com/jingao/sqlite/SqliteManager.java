package com.jingao.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jingao.Log.LogUtil;
import com.jingao.base.Operator;

/**
 * 
 * @ClassName: SqliteManager
 * @Description: TODO(初始化数据库)
 * @author Fengdi
 * @date 2017年8月23日
 *
 */
public class SqliteManager implements Operator {

	@Override
	public void init() throws Exception {
		try {
			Connection conn;
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 
	    * @Title: select
	    * @Description: TODO(从sqlite查出记录到list,list元素是hashmap,一个hashmap相当一条记录,key为字段名,value为字段值)
	    * @param @param sql
	    * @param @return    参数
	    * @return List<HashMap<String,Object>>    返回类型
	    * @throws
	 */
	public static List<HashMap<String, Object>> select(String sql) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs == null)
				return null;
			ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
			int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
			List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> rowData = new HashMap<String, Object>();
			while (rs.next()) {
				rowData = new HashMap<String, Object>(columnCount);
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);
				System.out.println("list:" + list.toString());
			}
			return list;
		} catch (SQLException e) {
			throw e;
		} finally {
			close(conn, stmt, rs);
		}
	}

	public static List<List<Object>> listSelect(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs == null)
				return null;
			ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
			int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
			List<List<Object>> list = new ArrayList<>();
			while (rs.next()) {
				List<Object> rowData = new ArrayList<>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.add(rs.getString(i));
				}
				list.add(rowData);
				System.out.println("list:" + list.toString());
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			close(conn, stmt, rs);
		}
	}

	public static void updateBatch(String sql) {
		if (sql == null) {
			return;
		}
		String[] tmp = sql.split(";");
		for (int i = 0; i < tmp.length; i++) {
			update(tmp[i]);
			LogUtil.log.info("batch sql" + tmp[i]);
		}
	}

	public static void update(String sql) {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}

	}

	public static void delete(String sql) {
		update(sql);
	}

	public static void add(String sql) {
		update(sql);
	}

	public static void create(String sql) {
		update(sql);
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
