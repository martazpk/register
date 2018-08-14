package pl.kopp.marta.repository;

import org.springframework.data.jpa.domain.Specification;
import pl.kopp.marta.domain.dto.StudentDto;
import pl.kopp.marta.domain.model.Student;

import java.util.List;

public interface StudentRepository {

    Student get(Long id);

    boolean isExist(long id);

    void add(Student student);

    void delete(long id);

    void update(Student student);

    List<Student> findAll(Specification<Student> specification);

    void deleteAll();
}
