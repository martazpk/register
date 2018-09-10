package pl.kopp.marta.student.domain.service;

import pl.kopp.marta.student.domain.dto.StudentDto;
import pl.kopp.marta.student.domain.model.Student;
import pl.kopp.marta.student.domain.service.exceptions.StudentDoesNotExistException;
import org.springframework.stereotype.Service;
import pl.kopp.marta.student.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentDto get(Long id) {
        if (repository.isExist(id)) {
            return repository.get(id).asDto();
        } else throw new StudentDoesNotExistException(id);
    }

    public Long add(StudentDto studentDto) {
            Student student = new Student(studentDto);
            repository.add(student);
            return student.getId();
    }

    public void delete(Long id) {
        if (repository.isExist(id)) {
            repository.delete(id);
        } else throw new StudentDoesNotExistException(id);
    }

    public void update(Long id, StudentDto studentDto) {
        if(repository.isExist(id)){
        Student student = repository.get(id);
        student.update(studentDto);
        repository.add(student);} else throw new StudentDoesNotExistException(id);
    }
}
