package com.jingao.spring;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.jingao.Config.ConfigDataPool;

@Component
public class TestBean {
	
	private String a = "";
	
	public TestBean(){
		
	}
	@PostConstruct
	public void init(){
		this.a = "ooooooo";
	}
	 public void say(){
		System.err.println("hello spring"+a);
	}
}
