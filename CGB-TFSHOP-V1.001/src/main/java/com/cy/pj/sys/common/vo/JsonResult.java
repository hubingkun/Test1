package com.cy.pj.sys.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class JsonResult implements Serializable{
	private static final long serialVersionUID = 5006046833266031595L;
	private int state=1;
	private String message="OK";
	private Object data;
	
	public JsonResult() {
		
	}
	public JsonResult(String message) {
		this.message=message;
	}
	public JsonResult(Object data) {
		this.data = data;
	}
	public JsonResult(Throwable t) {
		this.state=0;
		this.message=t.getMessage();
	}
}
