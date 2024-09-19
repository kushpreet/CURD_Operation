package com.springset2.springset2.blog_app.exceptions;

import com.springset2.springset2.blog_app.payloads.ApiResponse;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e){
        String message=e.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);


}
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> badRequestExceptionHandler(BadRequestException e) {
        String message = e.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MissingAttributeException.class)
    public ResponseEntity<ApiResponse> handleMissingAttributeException(MissingAttributeException e) {
        String message = e.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}