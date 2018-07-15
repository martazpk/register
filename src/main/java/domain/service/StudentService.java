package domain.service;

import domain.dto.StudentDto;
import domain.model.Student;
import domain.service.exceptions.StudentAlreadyExistsException;
import domain.service.exceptions.StudentDoesNotExistsException;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

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
        if (repository.isExist(studentDto.getPesel())) throw new StudentAlreadyExistsException(studentDto.getPesel());
        else {
            Student student = new Student(studentDto);
            repository.add(student);
            return student.getPesel();
        }
    }

    public void delete(Long id) {
        if (repository.isExist(id)) {
            repository.delete(id);
        } else throw new StudentDoesNotExistsException(id);
    }

    public void update(StudentDto studentDto) {
        Student student = repository.get(studentDto.getPesel());
        repository.update(student);
    }
}
