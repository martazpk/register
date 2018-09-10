package pl.kopp.marta.student.repository.JpaAdapter;

import org.springframework.data.jpa.domain.Specification;
import pl.kopp.marta.student.domain.model.Grade;
import pl.kopp.marta.student.repository.CrudJpaRepository.CrudJpaGradeRepository;
import pl.kopp.marta.student.repository.GradeRepository;

import java.util.List;

public class JpaDataGradeRepository implements GradeRepository {

    private final CrudJpaGradeRepository repository;

    public JpaDataGradeRepository(CrudJpaGradeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Grade get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public boolean isExist(long id) {
        return repository.exists(id);
    }

    @Override
    public void add(Grade grade) {
        repository.save(grade);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public void update(Grade grade) {
        repository.save(grade);
    }

    @Override
    public List<Grade> findAll(Specification<Grade> specification) {
        return repository.findAll(specification);
    }
}
