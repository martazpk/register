package pl.kopp.marta.student.repository;

import org.springframework.data.jpa.domain.Specification;
import pl.kopp.marta.student.domain.model.Grade;
import pl.kopp.marta.student.domain.model.Student;

import java.util.List;

public interface GradeRepository {
    Grade get(Long id);

    boolean isExist(long id);

    void add(Grade grade);

    void delete(long id);

    void update(Grade grade);

    List<Grade> findAll(Specification<Grade> specification);
}
