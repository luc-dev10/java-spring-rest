package com.rest.advice;

import com.rest.entity.GenericErrorResponse;
import com.rest.entity.StudentErrorResponse;
import com.rest.error.StudentNotFoundRunTimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    // add exception handling
    // add exception handler for calls
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundRunTimeException studentNotFoundRunTimeException) {

        // create response type
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentNotFoundRunTimeException.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(Exception exception) {

        // create response type
        GenericErrorResponse errorResponse = new GenericErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
