package com.survey.application.presentation.handler;


import com.survey.ws.AbstractResponse;
import com.survey.ws.SuccessResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.Serializable;


@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Serializable> {

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}

	@Override
	public Serializable beforeBodyWrite(Serializable body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		if(body instanceof AbstractResponse){
			return body;
		}else{
			return new SuccessResponse(body);
		}
	}

}
