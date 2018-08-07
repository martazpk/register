package pl.kopp.marta.repository.JPA;

import pl.kopp.marta.domain.model.Student;
import org.springframework.stereotype.Repository;
import pl.kopp.marta.repository.CrudJpaStudentRepository;
import pl.kopp.marta.repository.StudentRepository;


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

}
