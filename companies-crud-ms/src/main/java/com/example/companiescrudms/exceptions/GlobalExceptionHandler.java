package com.example.companiescrudms.exceptions;

import com.example.companiescrudms.services.interfaces.IExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private IExceptionService iExceptionService;

    @ExceptionHandler(ListEmptyException.class)
    public ResponseEntity<?> handleListEmptyException(ListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                iExceptionService.generateExcetionMessage("La lista se encuentra vacia", ex.getMessage())
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                iExceptionService.generateExcetionMessage("Ocurrio un error en la petición", ex.getMessage()
                )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(CreateEntityException.class)
    public ResponseEntity<?> handleCreateEntityException(CreateEntityException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                iExceptionService.generateExcetionMessage("Ocurrio un error en la creación del recurso", ex.getMessage())
        );
    }

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<?> handleNotFoundEntityException(NotFoundEntityException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                iExceptionService.generateExcetionMessage("Ocurrio un error en la busqueda del recurso", ex.getMessage())
        );
    }
}
