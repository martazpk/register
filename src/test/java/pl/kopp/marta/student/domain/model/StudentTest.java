package pl.kopp.marta.student.domain.model;

import org.junit.Test;
import pl.kopp.marta.student.domain.dto.StudentDto;

import static org.junit.Assert.*;

public class StudentTest {
    private static final String NAME="Peter";
    private static final String SURNAME="Parker";

    @Test
    public void shouldReturnStudentDtoWhenStudentIsGiven() {
        StudentDto initialDto=new StudentDto.Builder(NAME,SURNAME).build();
        Student student=new Student(initialDto);
        StudentDto dto=student.asDto();
        assertEquals(NAME,dto.getName());
        assertEquals(SURNAME,dto.getSurname());
    }

}