package pl.kopp.marta.student.repository.JpaAdapter;

import org.springframework.stereotype.Repository;
import pl.kopp.marta.student.domain.model.Classes;
import pl.kopp.marta.student.repository.ClassRepository;
import pl.kopp.marta.student.repository.CrudJpaRepository.CrudJpaClassRepository;

@Repository
public class JpaDataClassRepository implements ClassRepository {
    private final CrudJpaClassRepository repository;

    public JpaDataClassRepository(CrudJpaClassRepository repository) {
        this.repository = repository;
    }

    @Override
    public Classes get(long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public void update(Classes classes) {
        repository.save(classes);
    }

    @Override
    public void add(Classes classes) {
        repository.save(classes);
    }

    @Override
    public boolean isExists(long id) {
        return repository.exists(id);
    }
}
