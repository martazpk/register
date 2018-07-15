package domain.service.exceptions;

public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(Long pesel) {
        super("PESEL "+pesel+" already exists");
    }
}
