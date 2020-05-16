package co.com.apirest.apirest.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import co.com.apirest.apirest.exception.ApplicationException;
import co.com.apirest.apirest.exception.ClienteNoExisteException;

@ControllerAdvice
public class HandlerRestController {

	@ExceptionHandler({ ApplicationException.class })
	public ResponseEntity<Object> handlerApplicationException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler({ ClienteNoExisteException.class })
	public ResponseEntity<Object> handlerClienteNoExisteException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler({ Throwable.class })
	public ResponseEntity<Object> handlerErrorInterno(Exception ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
