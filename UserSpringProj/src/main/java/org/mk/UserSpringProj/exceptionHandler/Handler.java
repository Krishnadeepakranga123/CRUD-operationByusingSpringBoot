package org.mk.UserSpringProj.exceptionHandler;

import org.mk.UserSpringProj.dto.ResponseStructure;
import org.mk.UserSpringProj.exception.IdNotFoundException;
import org.mk.UserSpringProj.exception.InvalidCrediantialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class Handler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>>handleINFE(IdNotFoundException exception){
	
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("user not found");
		structure.setMessage(exception.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCrediantialException.class)
	public ResponseEntity<ResponseStructure<String>>handleICE(InvalidCrediantialException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("Cannot verify user");
		structure.setMessage(exception.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
