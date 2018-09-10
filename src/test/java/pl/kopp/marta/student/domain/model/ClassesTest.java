package pl.kopp.marta.student.domain.model;

import org.junit.Before;
import org.junit.Test;
import pl.kopp.marta.student.domain.dto.ClassesDto;

import static org.junit.Assert.*;

public class ClassesTest {
    private static final String NAME="Math";
    private static final String NEW_NAME="Algebra";
    private static final String DESCRIPTION="queen of sciences";
    private static Classes classes;

    @Before
    public void setUp() throws Exception {
        ClassesDto initialDto=new ClassesDto(NAME);
        initialDto.setDescription(DESCRIPTION);
        classes=new Classes(initialDto);
    }

    @Test
    public void shouldReturnClassesDtoWhenClassesIsGiven() throws Exception {
        ClassesDto dto=classes.asDto();
        assertEquals(NAME,dto.getName());
        assertEquals(DESCRIPTION,dto.getDescription());
    }

    @Test
    public void shouldUpdateClasses() throws Exception {
       ClassesDto newDto=new ClassesDto(NEW_NAME);
       classes.update(newDto);
       assertEquals(NEW_NAME,classes.getName());
    }
}