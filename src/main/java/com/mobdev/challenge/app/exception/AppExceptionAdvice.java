package com.mobdev.challenge.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionAdvice {
	
	@ExceptionHandler(value = CharacterNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlerCharacterNotFoundException(){

        Map<String,String> map = new HashMap<>();
        map.put("message","Character not found");
        return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Map<String,String>> handlerUserNotFoundException(){

        Map<String,String> map = new HashMap<>();
        map.put("message","Unexpected Error on process EndPoint");
        return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
