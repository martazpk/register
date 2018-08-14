package pl.kopp.marta.domain.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kopp.marta.domain.dto.QueryCriteriaDto;
import pl.kopp.marta.domain.dto.StudentDto;
import pl.kopp.marta.domain.model.Student;
import pl.kopp.marta.repository.StudentRepository;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentQueriesServiceTest {

    @Autowired
    private StudentRepository repository;
    private StudentQueriesService service;

    
    @Before
    public void setUp() throws Exception {
        service=new StudentQueriesService(repository);
        Student student1=new Student(new StudentDto.Builder("Marta","Awesome").build());
        Student student2=new Student(new StudentDto.Builder("Marta","Super").build());
        Student student3=new Student(new StudentDto.Builder("Maria","Super-duper").build());
        repository.add(student1);
        repository.add(student2);
        repository.add(student3);
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void shouldReturnListStudentDtoWhenNameIsGiven() throws Exception {

        QueryCriteriaDto query=new QueryCriteriaDto("name","equals","Marta");
        List<StudentDto> studentsBy = service.getStudentsBy(query);
        assertEquals(2,studentsBy.size());
        assertEquals("Marta",studentsBy.get(0).getName());
    }


    @Test
    public void shouldReturnEmptyListWhenSurnameIsNotExists() throws Exception {
        QueryCriteriaDto query=new QueryCriteriaDto("surname","equals","oalala");
        List<StudentDto> studentsBy = service.getStudentsBy(query);
        assertTrue(studentsBy.isEmpty());
    }
}
