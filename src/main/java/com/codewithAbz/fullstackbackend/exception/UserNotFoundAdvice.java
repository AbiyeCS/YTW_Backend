package com.codewithAbz.fullstackbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(UserNotFoundException e){

        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", e.getMessage());

        return errorMap;
    }
}

/*
* •	@ControllerAdvice: Indicates that this class provides centralized exception handling for controllers in the application.
•	@ExceptionHandler(UserNotFoundException.class): Specifies that this method handles exceptions of type UserNotFoundException.
•	@ResponseStatus(HttpStatus.NOT_FOUND): Sets the HTTP response status to 404 (Not Found).
•	@ResponseBody: Indicates that the return value of the method should be serialized directly into the response body.
•	The exceptionHandler method takes a UserNotFoundException as a parameter and
•	returns a Map containing an error message.

* */
