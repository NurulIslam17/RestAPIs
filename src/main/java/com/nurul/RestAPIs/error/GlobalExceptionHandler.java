package com.nurul.RestAPIs.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUsernameNotFoundException(UsernameNotFoundException e) {
        ApiError apiError = new ApiError("User not found with this name : " + e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError, apiError.getStatusCode());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleAccessDeniedException(AccessDeniedException e)
    {
        ApiError apiError = new ApiError( e.getMessage(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUsernameNotFoundException(Exception e) {

        ApiError apiError = new ApiError("And unexpected error occurred : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiError, apiError.getStatusCode());
    }

}
