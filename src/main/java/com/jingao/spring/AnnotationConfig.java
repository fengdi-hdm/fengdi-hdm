package com.jingao.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jingao.base.Operator;

public class AnnotationConfig implements Operator {

	@Override
	public void init() throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("prod"); // 先将激活的Profile设置为prod
		// ctx.register(Config.class, DevConfig.class, ProdConfig.class); //
		// 后置注册Bean配置类，不然为报Bean未定义的错误
		ctx.refresh();
		TestBean b = ctx.getBean(TestBean.class);
		b.say();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("prod"); // 先将激活的Profile设置为prod
		ctx.register(TestBean.class); //
		// 后置注册Bean配置类，不然为报Bean未定义的错误
		ctx.refresh();
		TestBean b = ctx.getBean(TestBean.class);
		b.say();
	}
}
