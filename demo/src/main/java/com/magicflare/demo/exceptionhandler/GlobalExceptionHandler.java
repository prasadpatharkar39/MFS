package com.magicflare.demo.exceptionhandler;

import com.magicflare.demo.exceptionhandler.exception.NoResourceFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(NoResourceFoundException ex) {
Map<String,String> response = new HashMap<>();
log.error("NoResourceFoundException occur  "+ex.getMessage());
        response.put("Error",ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?>  handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
//        return errorMap;
       return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

}
