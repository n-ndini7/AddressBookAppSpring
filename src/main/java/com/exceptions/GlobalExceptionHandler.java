package com.exceptions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dto.ResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO response = new ResponseDTO("Exception while processing REST request",errMsg);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<ResponseDTO> handleAddressBookException(AddressBookException exception){
		ResponseDTO response = new ResponseDTO("Exception while processing REST request",exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<ResponseDTO> NoElementException(NoSuchElementException e) {
		ResponseDTO status = new ResponseDTO("User does not exist in Address Book!!");
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.OK);
	}
	
}
