package com.jingao.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.ibatis.session.SqlSession;

import com.jingao.Config.ConfigManager;
import com.jingao.DB.DBUtil;
import com.jingao.DB.SessionFacoty;
import com.jingao.DB.beans.Blog;
import com.jingao.DB.beans.JiraIssue;
import com.jingao.DB.beans.Two;
import com.jingao.DB.mapper.BlogMapper;
import com.jingao.DB.mapper.JiraIssueMapper;
import com.jingao.Job.QuartzManager;
import com.jingao.Log.Log4jManager;
import com.jingao.Log.LogUtil;
import com.jingao.base.Operator;
import com.jingao.http.HttpManager;
import com.jingao.sqlite.SqliteManager;
import com.jingao.window.PublicWindow;
import com.jingao.window.data.FieldValueManager;

/**
 * 
 * @ClassName: Main
 * @Description: TODO(程序入口)
 * @author Administrator
 * @date 2017年8月10日
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.init();
		// m.test();

	}

	/**
	 * 
	 * @Title: init @Description: TODO(启动时的初始化工作) @param 参数 @return void
	 * 返回类型 @throws
	 */
	public void init() {
		ArrayList<Class<?>> list = new ArrayList<Class<?>>();
		// 需要初始化的类在这里注册
		list.add(Log4jManager.class);
		list.add(ConfigManager.class);
		list.add(HttpManager.class);
		list.add(QuartzManager.class);
		list.add(SqliteManager.class);
		list.add(PublicWindow.class);
		list.add(FieldValueManager.class);

		for (Class<?> className : list) {
			System.err.println(className.getName());
			try {
				Class<?> clazz = Class.forName(className.getName());
				Operator op = (Operator) clazz.newInstance();
				op.init();
			} catch (Exception e) {
				LogUtil.log.info(e.getMessage(), e);
				// 初始化异常退出
				System.exit(0);
			}
		}
	}

	public void running() {
	}

	public void stop() {
	}

	public void test() {
		SqlSession session = SessionFacoty.getInston().openSession();
		JiraIssueMapper jmapper = session.getMapper(JiraIssueMapper.class);
		JiraIssue j = jmapper.selectIssue("10002");
		System.err.println(j.getSUMMARY());
		System.err.println(j.getEmail_address());
		List<JiraIssue> list = jmapper.selectIssues();
		System.err.println(list.size());
		System.err.println((list.get(10)).getID());
		List<HashMap<String, String>> map = jmapper.selectMap();
		System.err.println(map.size());
		System.err.println(map.get(0).toString());
		List<Two> two = jmapper.selectTwo();
		System.err.println("two=" + two.size());
		HashMap tomap = DBUtil.DBListToMap(two);
		System.err.println(tomap.toString());
	}

}
