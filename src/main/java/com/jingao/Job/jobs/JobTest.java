package com.jingao.Job.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.jingao.Log.LogUtil;
import com.jingao.Script.JsEngin;

public class JobTest implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		LogUtil.log.info("quartz test");
		try {
			
		} catch (Exception e) {
			LogUtil.log.info(e.getMessage(),e);
		}
		//JsEngin.dealScript(new String[]{"D:\\Users\\Administrator\\workspace\\new\\jira_public\\script\\script.js"});
	}

}
