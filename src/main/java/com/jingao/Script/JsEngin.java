package com.jingao.Script;

import java.io.File;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.jingao.Log.LogUtil;

/**
 * 
    * @ClassName: JsEngin
    * @Description: TODO(执行脚本引擎,通过结合job或者http rest 可以动态调用script 脚本)
    * @author Fengdi
    * @date 2017年8月18日
    *
 */
public class JsEngin {
	public static void dealScript(String[] args) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		try {
			for (int i = 0; i < args.length; i++) {
				File file = new File(args[i]).getAbsoluteFile();
				System.out.println("args[" + i + "] is" + file);
				if (file.isFile()) {
					String strJSName = args[i];// For Jar
					nashorn.eval(new FileReader(strJSName));
					Object eval = nashorn.eval("make('" + strJSName + "')");// 传递参数strJSName到JS脚本
				} else {
					System.out.println("Java运行命令参数非法，请检查！");
				}
			
			}
		} catch (Exception e) {
			LogUtil.log.info("Error executing script: " + e.getMessage());
		}
	}
}
