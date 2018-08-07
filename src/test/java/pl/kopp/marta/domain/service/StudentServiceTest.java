package pl.kopp.marta.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kopp.marta.domain.dto.StudentDto;
import pl.kopp.marta.domain.service.exceptions.StudentDoesNotExistsException;
import pl.kopp.marta.repository.StudentRepository;

import javax.naming.Name;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;
    private StudentService service;
    private String NAME = "Peter";
    private String NEW_NAME="Spider-Man";
    private String SURNAME = "Parker";
    private Long WRONG_ID = 12345678911L;

    @Before

    public void setUp() {
        service = new StudentService(repository);
    }

    @Test(expected = StudentDoesNotExistsException.class)
    public void shouldThrowsExceptionWhenStudentDoesNotExists(){
        service.get(WRONG_ID);
    }


    @Test
    public void shouldReturnStudentWhenStudentExists() throws Exception {
        Long id = givenStudent(NAME,SURNAME);
        StudentDto studentDto = service.get(id);
        assertEquals(NAME,studentDto.getName());
        assertEquals(SURNAME,studentDto.getSurname());
    }

    @Test
    public void shouldDeleteStudent() throws Exception {
        Long id = givenStudent(NAME,SURNAME);
        service.delete(id);
        assertFalse(repository.isExist(id));
    }

    @Test
    public void shouldUpdateStudent() throws Exception {
        Long id = givenStudent(NAME,SURNAME);
        StudentDto studentDto=new StudentDto.Builder(NEW_NAME,SURNAME).build();
        service.update(id,studentDto);
        StudentDto changedStudent = service.get(id);
        assertEquals(NEW_NAME,changedStudent.getName());

    }

    private Long givenStudent(String name, String surname) {
        StudentDto studentDto=new StudentDto.Builder(NAME, SURNAME).build();
        return service.add(studentDto);
    }
}