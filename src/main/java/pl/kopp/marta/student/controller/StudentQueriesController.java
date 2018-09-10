package pl.kopp.marta.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kopp.marta.student.domain.dto.QueryCriteriaDto;
import pl.kopp.marta.student.domain.dto.StudentDto;
import pl.kopp.marta.student.domain.service.StudentQueriesService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentQueriesController {

    @Autowired
    StudentQueriesService service;

    @RequestMapping(method= RequestMethod.POST)
    public List<StudentDto> getByCriteria (@ModelAttribute QueryCriteriaDto criteria){
        return service.getStudentsBy(criteria);
    }
}
