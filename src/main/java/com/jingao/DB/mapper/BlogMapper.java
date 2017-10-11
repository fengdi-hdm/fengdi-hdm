package com.jingao.DB.mapper;

import org.apache.ibatis.annotations.Select;

import com.jingao.DB.beans.Blog;

public interface BlogMapper {
	@Select("select * from blog where id = #{id}")
	Blog selectBlog(int id);
}
