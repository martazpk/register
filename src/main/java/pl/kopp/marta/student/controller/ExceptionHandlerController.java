package pl.kopp.marta.student.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.kopp.marta.student.domain.service.exceptions.ClassesDoesNotExistException;
import pl.kopp.marta.student.domain.service.exceptions.StudentDoesNotExistException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({StudentDoesNotExistException.class, ClassesDoesNotExistException.class})
    public ResponseEntity<String>notFound(RuntimeException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
}
