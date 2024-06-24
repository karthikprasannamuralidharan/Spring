package com.example.demo.wrapperClass;

import org.springframework.stereotype.Component;

@Component
public class WrapperClass {
	String msg;
	Object data;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
