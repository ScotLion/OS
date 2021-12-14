package com.alessandro.os.controller.excepitions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alessandro.os.services.exception.DataIntegrityViolationExeption;
import com.alessandro.os.services.exception.ObjectNotFoundExeption;

@ControllerAdvice
public class ResourceExceptionHandle {

	@ExceptionHandler(ObjectNotFoundExeption.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundExeption e) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationExeption.class)
	public ResponseEntity<StandardError> DataIntegrityViolationExeption(DataIntegrityViolationExeption e) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> objectNotFoundException(MethodArgumentNotValidException e) {
		ValidationErro error = new ValidationErro(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na Validação dos Campos");
				
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			error.setFieldMessage(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
