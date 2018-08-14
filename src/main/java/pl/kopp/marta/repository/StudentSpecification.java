package pl.kopp.marta.repository;

import org.springframework.data.jpa.domain.Specification;
import pl.kopp.marta.domain.dto.QueryCriteriaDto;
import pl.kopp.marta.domain.model.Student;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class StudentSpecification implements Specification<Student> {
    private final QueryCriteriaDto criteria;

    public StudentSpecification(QueryCriteriaDto criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
    switch (criteria.getType()) {

        case "equals":
            return criteriaBuilder.equal(root.get(criteria.getColumnName()), criteria.getValue());

        case "not":
            return criteriaBuilder.notEqual(root.get(criteria.getColumnName()), criteria.getValue());

        default:
            throw new IllegalArgumentException("Invalid type: " + criteria.getType());
    }
}
}
