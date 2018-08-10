package pl.kopp.marta.repository.JPA;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kopp.marta.domain.dto.StudentDto;
import pl.kopp.marta.domain.model.Student;
import pl.kopp.marta.repository.CrudJpaStudentRepository;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudJpaStudentRepositoryTest {

    @Autowired
    CrudJpaStudentRepository repository;

    @Test
    public void shouldAddStudent() throws Exception {
        String name="Peter";
        String surname="Parker";
        Student student=createdStudent(name,surname);
        repository.save(student);
        assertTrue(repository.exists(student.getId()));
    }

    private Student createdStudent(String name, String surname) {
        return new Student(new StudentDto.Builder(name,surname).build());
    }

    @Test
    public void shouldDeleteStudent() throws Exception {
        String name="Peter";
        String surname="Parker";
        Student student=createdStudent(name,surname);
        repository.save(student);
        repository.delete(student.getId());
        assertFalse(repository.exists(student.getId()));
    }
}