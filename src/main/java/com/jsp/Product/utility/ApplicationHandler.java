package com.jsp.Product.utility;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.Product.exception.ProductNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler{

	/*@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> productNotFoundByIdException(ProductNotFoundByIdException ex){
		
		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Product Object with the given Id doesn't exits!!");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}*/
	
	private ErrorStructure structure;
	
	public ApplicationHandler(ErrorStructure structure) {
		super();
		this.structure = structure;
	}

    @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
    	
		List<ObjectError> allErrors = ex.getAllErrors();
		
		Map<String, String> messages = new LinkedHashMap<String, String>();
		
		allErrors.forEach(error->{
			FieldError fe = (FieldError)error;
			messages.put(fe.getField(), fe.getDefaultMessage());
		});
		
		return ResponseEntity.badRequest().body(structure.setStatusCode(HttpStatus.BAD_REQUEST.value())
				                                         .setErrorMessage("Invalid inputs")
				                                         .setRootCause(messages));
	}
}
