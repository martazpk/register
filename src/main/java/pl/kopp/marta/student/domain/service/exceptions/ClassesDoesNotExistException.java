package pl.kopp.marta.student.domain.service.exceptions;

public class ClassesDoesNotExistException extends RuntimeException {
    public ClassesDoesNotExistException(long id) {
        super("Classes "+id+" does not exist");
    }
}
