package com.jingao.http.resources;

import java.lang.reflect.Method;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.jingao.util.MD5;

/**
 * 
 * @ClassName: CommWithHttp
 * @Description: TODO(该类通过http请求控制执行服务暴露给外部的接口,根据传过来的参数和方法名执行相应方法)
 * @author Fengdi
 * @date 2017年8月18日
 *
 */
@Path("Comm")
public class CommWithHttp {
	private static String key = "fengdi";

	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public static void excute(@QueryParam("user") String user, @QueryParam("methodName") String method,
			@QueryParam("param") String param) {
		String token = MD5.getMD5(CommWithHttp.key + method);
		// 启用用户验证,判断请求是否合法,正式上线根据情况加参数判断时效性
		System.err.println(token);
		if (token.equals(user)) {
			// do sth
		}
		try {
			Class<?> comm = Class.forName(CommWithHttp.class.getName());
			Method m = comm.getDeclaredMethod(method);
			Object o = new Object();
			m.invoke(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sayHello(){
		System.err.println("hello");
	}
}
