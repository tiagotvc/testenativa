package com.nativa.testenativa.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError {
	private static final long serialVersionUID = 1l;
	
	private List<FieldMessage> list = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		
	}

	public List<FieldMessage> getList() {
		return list;
	}

	public void addError(String fieldName, String messagem) {
		list.add(new FieldMessage(fieldName, messagem));
	}

	}
	
	
	

