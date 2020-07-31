package com.survey.application.presentation.handler;

import com.survey.application.presentation.errors.Error;
import com.survey.exception.PresentationException;
import com.survey.ws.AbstractResponse;
import com.survey.ws.BadRequestResponse;
import com.survey.ws.FailResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j2
@RestControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<FailResponse> exception(Locale locale, Exception exception) {
		FailResponse failResponse = new FailResponse(Error.DEFAULT.getCode(), Error.DEFAULT.getMessage());
		log.warn(failResponse.getId(), exception);
		return ResponseEntity.status(Error.DEFAULT.getStatus()).body(failResponse);
	}

	@ExceptionHandler({ PresentationException.class })
	public ResponseEntity<AbstractResponse> baseException(Locale locale, PresentationException surveyException) {
		FailResponse failResponse = new FailResponse(surveyException.getError().getCode(), surveyException.getError().getMessage());
		log.warn(failResponse.getId(), surveyException);
		return ResponseEntity.status(surveyException.getError().getStatus()).body(failResponse);
	}

	@ExceptionHandler({ javax.validation.ConstraintViolationException.class })
	public ResponseEntity<AbstractResponse> baseException(Locale locale, ConstraintViolationException constraintViolationException) {
		Map<String, String> errors = constraintViolationException.getConstraintViolations().stream().collect(Collectors.toMap(x -> x.getPropertyPath().toString(), x -> x.getMessage()));
		BadRequestResponse badRequestResponse = new BadRequestResponse(Error.BAD_REQUEST.getCode(), Error.BAD_REQUEST.getMessage(), errors);
		log.warn(badRequestResponse.getId(), constraintViolationException);
		return ResponseEntity.status(Error.BAD_REQUEST.getStatus()).body(badRequestResponse);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<AbstractResponse> methodArgumentNotValidException(Locale locale, MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> errors = methodArgumentNotValidException.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(x -> x.getField(), x -> x.getDefaultMessage()));
		BadRequestResponse badRequestResponse = new BadRequestResponse(Error.BAD_REQUEST.getCode(), Error.BAD_REQUEST.getMessage(), errors);
		log.warn(badRequestResponse.getId(), methodArgumentNotValidException);
		return ResponseEntity.status(Error.BAD_REQUEST.getStatus()).body(badRequestResponse);
	}

}
