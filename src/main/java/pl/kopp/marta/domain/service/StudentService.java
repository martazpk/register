package pl.kopp.marta.domain.service;

import pl.kopp.marta.domain.dto.StudentDto;
import pl.kopp.marta.domain.model.Student;
import pl.kopp.marta.domain.service.exceptions.StudentDoesNotExistsException;
import org.springframework.stereotype.Service;
import pl.kopp.marta.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    StudentDto get(Long id) {
        if (repository.isExist(id)) {
            return repository.get(id).asDto();
        } else throw new StudentDoesNotExistsException(id);
    }

    Long add(StudentDto studentDto) {
            Student student = new Student(studentDto);
            repository.add(student);
            return student.getId();
    }

    public void delete(Long id) {
        if (repository.isExist(id)) {
            repository.delete(id);
        } else throw new StudentDoesNotExistsException(id);
    }

    public void update(Long id, StudentDto studentDto) {
        Student student = repository.get(id);
        student.update(studentDto);
        repository.add(student);
    }
}
