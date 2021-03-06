package pl.kopp.marta.student.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.kopp.marta.student.domain.dto.QueryCriteriaDto;
import pl.kopp.marta.student.domain.dto.StudentDto;
import pl.kopp.marta.student.domain.model.Student;
import pl.kopp.marta.student.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentQueriesService {

    @Autowired
    private final StudentRepository repository;

    public StudentQueriesService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentDto> getStudentsBy(QueryCriteriaDto criteria){
        Specification<Student> specifications=aSpecificationFrom(criteria);
        List<Student>students=repository.findAll(specifications);
        return  asDtos(students);
    }

    private List<StudentDto> asDtos(List<Student> students) {
        return students.stream()
                .map(Student::asDto)
                .collect(Collectors.toList());
    }

    private Specification<Student> aSpecificationFrom(QueryCriteriaDto queryDTO) {
        return (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.equal(root.get(queryDTO.getColumnName()), queryDTO.getValue());
    }
}
