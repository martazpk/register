package pl.kopp.marta.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.kopp.marta.domain.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudJpaStudentRepository extends CrudRepository<Student,Long>,JpaSpecificationExecutor<Student> {


}
