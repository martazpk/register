package pl.kopp.marta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.kopp.marta.domain.service.exceptions.StudentDoesNotExistsException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({StudentDoesNotExistsException.class,})
    public ResponseEntity<String>notFound(RuntimeException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
}
