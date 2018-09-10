package pl.kopp.marta.student.repository.CrudJpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kopp.marta.student.domain.model.Grade;

@Repository
public interface CrudJpaGradeRepository extends CrudRepository<Grade,Long>,JpaSpecificationExecutor<Grade>{
}
