package com.jingao.Log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
	public static Logger log = LogManager.getLogger("console");
	public static Logger err = LogManager.getLogger("error");
	public static Logger done = LogManager.getLogger("done");
}
