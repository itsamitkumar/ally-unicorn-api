package com.ally.poc.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ally.poc.model.ErrorResponse;
import com.fasterxml.jackson.databind.JsonMappingException;

@ControllerAdvice
public class AppExceptionHandler 
{
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public final ResponseEntity<ErrorResponse> processException(Exception ex) 
	{
		ErrorResponse error = new ErrorResponse(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
  
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
  @ResponseBody
  public final ResponseEntity<ErrorResponse> processMethodNotSupportedException(Exception ex) 
	{
		ErrorResponse error = new ErrorResponse(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
	}
  
  @ExceptionHandler({HttpMessageNotReadableException.class ,MethodArgumentNotValidException.class ,JsonMappingException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public final ResponseEntity<ErrorResponse> processBadRequestException(Exception ex) 
	{
		ErrorResponse error = new ErrorResponse(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
  
  @ExceptionHandler(RecordNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ResponseBody
  public final ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex) 
	{
		ErrorResponse error = new ErrorResponse(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
   
  
}
