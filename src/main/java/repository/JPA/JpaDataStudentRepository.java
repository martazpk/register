package repository.JPA;

import domain.model.Student;
import org.springframework.data.jpa.domain.Specification;
import repository.CrudJpaStudentRepository;
import repository.StudentRepository;

import java.util.List;

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


}
