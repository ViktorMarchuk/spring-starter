package com.vm.springstarter.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice(basePackages = "com.vm.springstarter.http.rest")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

}
