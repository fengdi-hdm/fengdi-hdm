package com.jingao.Job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import com.jingao.base.Operator;

/**
 * 
    * @ClassName: QuartzManager
    * @Description: TODO(定时调度控制)
    * @author Fengdi
    * @date 2017年8月18日
    *
 */
public class QuartzManager implements Operator {
	private Scheduler createScheduler() throws SchedulerException {// 创建调度器
		return new StdSchedulerFactory("quartz.properties"
				+ "").getScheduler();
	}

	/**
	 * 此处没有设计成单例,要避免多次初始化
	 */
	public void init() throws Exception {
		Logger logger = (Logger) LogManager.getLogger("console");
		logger.info("启动定时器");
		QuartzManager quartz = new QuartzManager();
		try {
			Scheduler scheduler = quartz.createScheduler();
			scheduler.start();
			logger.info("启动定时器完毕");
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
