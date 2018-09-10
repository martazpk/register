package pl.kopp.marta.student.repository.JpaAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kopp.marta.student.domain.dto.StudentDto;
import pl.kopp.marta.student.domain.model.Grade;
import pl.kopp.marta.student.domain.model.Student;
import pl.kopp.marta.student.repository.CrudJpaRepository.CrudJpaStudentRepository;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudJpaStudentRepositoryTest {
    private static final String NAME = "Peter";
    private static final String SURNAME = "Parker";
    private Student student;

    @Autowired
    CrudJpaStudentRepository repository;

    @Before
    public void createAndAddStudent() throws Exception {
        student = new Student(new StudentDto.Builder(NAME, SURNAME).build());
        repository.save(student);
    }

    @Test
    public void shouldAddStudent() throws Exception {
        assertTrue(repository.exists(student.getId()));
    }


    @Test
    public void shouldDeleteStudent() throws Exception {
        repository.delete(student.getId());
        assertFalse(repository.exists(student.getId()));
    }

    @Test
    public void shouldGetStudentWhenIdIsGiven() throws Exception {
        Student takenStudent = repository.findOne(student.getId());
        assertEquals(NAME, takenStudent.getName());
        assertEquals(SURNAME, takenStudent.getSurname());


    }
}