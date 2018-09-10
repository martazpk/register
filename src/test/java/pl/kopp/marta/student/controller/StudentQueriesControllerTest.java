package pl.kopp.marta.student.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.kopp.marta.student.domain.dto.StudentDto;
import pl.kopp.marta.student.domain.model.Student;
import pl.kopp.marta.student.domain.service.StudentQueriesService;
import pl.kopp.marta.student.repository.CrudJpaRepository.CrudJpaStudentRepository;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentQueriesControllerTest {

    @Autowired
    CrudJpaStudentRepository repository;
    @Autowired
    StudentQueriesService service;
    @Autowired
    private MockMvc chrome;
    @Before
    public void setUp() throws Exception {

        Student student1=new Student(new StudentDto.Builder("Marta","Awesome").build());
        Student student2=new Student(new StudentDto.Builder("Marta","Super").build());
        Student student3=new Student(new StudentDto.Builder("Maria","Super-duper").build());
        repository.save(student1);
        repository.save(student2);
        repository.save(student3);
    }

    @Test
    public void shouldReturnHttpResponseStatusOk() throws Exception {
        String columnName = "name";
        String type = "equals";
        String value = "Marta";

        MockHttpServletResponse response = chrome.perform(MockMvcRequestBuilders.
                post("/students")
                .param("columnName", columnName)
                .param("type", type)
                .param("value", value)

        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}