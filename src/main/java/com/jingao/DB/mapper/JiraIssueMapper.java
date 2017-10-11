package com.jingao.DB.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jingao.DB.beans.JiraIssue;
import com.jingao.DB.beans.Two;

public interface JiraIssueMapper {
	@Select("select *,email_address from jiraissue,cwd_user where jiraissue.id = #{ID} and CREATOR = last_name")
	JiraIssue selectIssue(String ID);
	
	@Select("select * from jiraissue")
	List<JiraIssue> selectIssues();
	
	@Select("select * from jiraissue")
	List<HashMap<String,String>> selectMap();
	
	@Select("select ID as `key`,SUMMARY as value from jiraissue")
	List<Two> selectTwo();
}
