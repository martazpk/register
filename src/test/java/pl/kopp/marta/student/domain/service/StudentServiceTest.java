package pl.kopp.marta.student.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kopp.marta.student.domain.dto.StudentDto;
import pl.kopp.marta.student.domain.service.exceptions.StudentDoesNotExistException;
import pl.kopp.marta.student.repository.StudentRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;
    private StudentService service;
    private final static String NAME = "Peter";
    private final static String NEW_NAME="Spider-Man";
    private final static String SURNAME = "Parker";
    private final static Long WRONG_ID = 12345678911L;

    @Before
    public void setUp() {
        service = new StudentService(repository);
    }

    @Test(expected = StudentDoesNotExistException.class)
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
        StudentDto studentDto=new StudentDto.Builder(name, surname).build();
        return service.add(studentDto);
    }
}