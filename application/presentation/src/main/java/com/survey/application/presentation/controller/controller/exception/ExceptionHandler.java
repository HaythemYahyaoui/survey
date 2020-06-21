package com.survey.application.presentation.controller.controller.exception;

import com.survey.ws.AbstractResponse;
import com.survey.ws.FailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.BindException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class ExceptionHandler {

	private static final Logger LOG = Logger.getLogger(ExceptionHandler.class.getName());

	@org.springframework.web.bind.annotation.ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<AbstractResponse> dethodArgumentTypeMismatchException(Locale locale,
			MethodArgumentTypeMismatchException dethodArgumentTypeMismatchException) {
		LOG.log(Level.SEVERE,"", dethodArgumentTypeMismatchException);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new FailResponse(400L, dethodArgumentTypeMismatchException.getMessage()));
	}

	@org.springframework.web.bind.annotation.ExceptionHandler({ BindException.class })
	public ResponseEntity<AbstractResponse> bindException(Locale locale, BindException bindException) {
		LOG.log(Level.SEVERE,"", bindException);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailResponse(400L, bindException.getMessage()));
	}

	@org.springframework.web.bind.annotation.ExceptionHandler({ Exception.class })
	public ResponseEntity<AbstractResponse> exception(Locale locale, Exception exception) {
		LOG.log(Level.SEVERE,"", exception);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new FailResponse(500L, exception.getMessage()));
	}

}
