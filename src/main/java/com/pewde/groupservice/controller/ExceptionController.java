package com.pewde.groupservice.controller;

import com.pewde.groupservice.exception.HttpException;
import com.pewde.groupservice.mapper.ExceptionMapper;
import com.pewde.groupservice.response.ExceptionResponse;
import feign.FeignException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Hidden
@ControllerAdvice
public class ExceptionController {

    @Autowired
    private ExceptionMapper exceptionMapper;

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ExceptionResponse> handleException(HttpException exception){
        ExceptionResponse response = exceptionMapper.mapExceptionToExceptionResponse(exception);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ExceptionResponse> handleFeignException(FeignException exception){
        ExceptionResponse response = exceptionMapper.mapFeignExceptionToExceptionResponse(exception);
        return new ResponseEntity<>(response, response.getStatus());
    }

}
