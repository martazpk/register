package pl.kopp.marta.repository;

import pl.kopp.marta.domain.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudJpaStudentRepository extends CrudRepository<Student,Long> {
}
