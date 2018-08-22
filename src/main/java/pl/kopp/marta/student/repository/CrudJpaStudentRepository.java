package pl.kopp.marta.student.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.kopp.marta.student.domain.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudJpaStudentRepository extends CrudRepository<Student,Long>,JpaSpecificationExecutor<Student> {


}
