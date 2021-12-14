package com.alessandro.os.controller.excepitions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErro extends StandardError{

	
	private static final long serialVersionUID = 1L;
	private List<FieldMessage> fieldMessage = new ArrayList<>();
	public ValidationErro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ValidationErro(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}
	public List<FieldMessage> getFieldMessage() {
		return fieldMessage;
	}
	public void setFieldMessage(String fieldeName, String Message) {
		this.fieldMessage.add(new FieldMessage(fieldeName, Message));
	}
	
	

}
