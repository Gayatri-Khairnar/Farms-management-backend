package com.agro.exception;

import com.agro.utils.APIResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(GenricProcessException.class)
    public ResponseEntity<APIResponse> handleGenricProcessException(GenricProcessException ex) {
        APIResponse response = new APIResponse(false,ex.getMessage(),ex.getStatusCode());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
