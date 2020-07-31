package com.survey.ws;

import java.util.Map;

public class BadRequestResponse extends FailResponse {

	private final Map<String, String> errors;

	public BadRequestResponse(Long code, String message, Map<String, String> errors) {
		super(code, message);
		this.errors = errors;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
}
