package com.qualcomm.chip.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
      Exception ex, WebRequest request) {
        //return new ResponseEntity<Object>(
          //"ACOSS denied", new HttpHeaders(), HttpStatus.FORBIDDEN);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }
    
    @ExceptionHandler({ BadCredentialsException.class })
    public ResponseEntity<Object> handleAuthenticationException(
      Exception ex, WebRequest request) {
        //return new ResponseEntity<Object>(
         // "UNathorized", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    
}