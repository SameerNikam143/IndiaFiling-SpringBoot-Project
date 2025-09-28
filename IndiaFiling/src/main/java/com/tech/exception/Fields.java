package com.tech.exception;

import java.util.Date;

public class Fields {

	private Integer errorCode;
	
	private String message;
	
	private Date  date;
	
	public Fields(Integer code,String msg,Date d) {
		this.date=d;
		this.errorCode=code;
		this.message=msg;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}
	
	
}
