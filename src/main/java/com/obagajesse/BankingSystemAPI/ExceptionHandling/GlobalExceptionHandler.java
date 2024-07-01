package com.obagajesse.BankingSystemAPI.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity<CustomErrorResponse> handleInvalidInput(InvalidInputException ex, HttpStatus status, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(405,"Invalid Input.");
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
