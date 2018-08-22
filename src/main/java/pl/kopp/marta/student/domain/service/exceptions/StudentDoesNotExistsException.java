package pl.kopp.marta.student.domain.service.exceptions;

public class StudentDoesNotExistsException extends RuntimeException {
    public StudentDoesNotExistsException(Long id) {
        super("Student "+id+" does not exists");
    }
}
