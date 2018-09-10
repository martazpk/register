package pl.kopp.marta.student.domain.service.exceptions;

public class StudentDoesNotExistException extends RuntimeException {
    public StudentDoesNotExistException(Long id) {
        super("Student "+id+" does not exists");
    }
}
