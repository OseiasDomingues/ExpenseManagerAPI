package com.dl.MoneyApi.controllers.exceptions;

import com.dl.MoneyApi.models.response.ResponsePadrao;
import com.dl.MoneyApi.services.exceptions.DatabaseException;
import com.dl.MoneyApi.services.exceptions.EntityNotFoundException;
import com.dl.MoneyApi.services.exceptions.FieldInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ResponsePadrao> objNotFound(EntityNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new ResponsePadrao(status.value(), e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(DatabaseException.class)
    ResponseEntity<ResponsePadrao> databaseError(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(new ResponsePadrao(status.value(), e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(FieldInvalidException.class)
    ResponseEntity<ResponsePadrao> fieldInvalid(FieldInvalidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(new ResponsePadrao(status.value(), e.getMessage(), request.getRequestURI()));
    }
}
