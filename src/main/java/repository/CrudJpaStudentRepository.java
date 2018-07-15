package repository;

import domain.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudJpaStudentRepository extends CrudRepository<Student,Long> {
}
