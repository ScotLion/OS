package com.alessandro.os.controller.excepitions;

import java.io.Serializable;

public class FieldMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String FieldName;
	private String message;
	public FieldMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FieldMessage(String fieldName, String message) {
		super();
		FieldName = fieldName;
		this.message = message;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
