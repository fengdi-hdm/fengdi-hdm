package com.jingao.DB;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jingao.Config.ConfigDataPool;
/**
 * 
    * @ClassName: SessionFacoty
    * @Description: TODO(mybatis 获取数据库链接)
    * @author Administrator
    * @date 2017年8月11日
    *
 */
public class SessionFacoty {

	private String resource = ConfigDataPool.config("config").get("DBConfigPath");
	public static SqlSessionFactory sqlSessionFactory = null;

	private SessionFacoty() {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static synchronized SqlSessionFactory getInston() {
		if (sqlSessionFactory != null) {
			return sqlSessionFactory;
		} else {
			return new SessionFacoty().sqlSessionFactory;
		}
	}

	public SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}

}
