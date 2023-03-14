package it.sonia.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {

    String messageAlreadyExist = "username already exist!";
    @org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handlerRegister(UserAlreadyExistException userAlreadyExistException){
        return new ResponseEntity<>(messageAlreadyExist, HttpStatus.valueOf(200));
    }
}
