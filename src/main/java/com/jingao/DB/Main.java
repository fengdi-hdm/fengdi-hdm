package com.jingao.DB;

import org.apache.ibatis.session.SqlSession;

import com.jingao.DB.beans.Blog;
import com.jingao.DB.mapper.BlogMapper;

public class Main {
	public static void main(String[] args) {
		SqlSession session = SessionFacoty.getInston().openSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		Blog b = mapper.selectBlog(1);
		System.err.println(b.getAuther());
	}
}
