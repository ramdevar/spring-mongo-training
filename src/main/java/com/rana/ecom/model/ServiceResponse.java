package com.rana.ecom.model;

import java.io.Serializable;

public class ServiceResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8647062578126470904L;
	
	private String status;
	private String msg;
	private Object obj;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
	
	

}
