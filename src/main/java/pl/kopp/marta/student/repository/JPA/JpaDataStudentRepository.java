package pl.kopp.marta.student.repository.JPA;

import org.springframework.data.jpa.domain.Specification;
import pl.kopp.marta.student.domain.model.Student;
import org.springframework.stereotype.Repository;
import pl.kopp.marta.student.repository.CrudJpaStudentRepository;
import pl.kopp.marta.student.repository.StudentRepository;

import java.util.List;


@Repository
public class JpaDataStudentRepository implements StudentRepository {
    private final CrudJpaStudentRepository repository;

    public JpaDataStudentRepository(CrudJpaStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public boolean isExist(long id) {
        return repository.exists(id);
    }

    @Override
    public void add(Student student) {
        repository.save(student);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public void update(Student student) {
        repository.save(student);
    }

    @Override
    public List<Student> findAll(Specification<Student> specification) {
        return repository.findAll(specification);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}
