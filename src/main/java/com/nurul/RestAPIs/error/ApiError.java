package com.nurul.RestAPIs.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError {

    private LocalDateTime localDateTime;
    private String error;
    private HttpStatus statusCode;


    public ApiError( String error, HttpStatus statusCode) {
        this.localDateTime = LocalDateTime.now();
        this.error = error;
        this.statusCode = statusCode;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
