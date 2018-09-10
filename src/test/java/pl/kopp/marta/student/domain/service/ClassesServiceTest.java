package pl.kopp.marta.student.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kopp.marta.student.domain.dto.ClassesDto;
import pl.kopp.marta.student.domain.service.exceptions.ClassesDoesNotExistException;
import pl.kopp.marta.student.repository.ClassRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClassesServiceTest {
    @Autowired
    private ClassRepository repository;
    private ClassesService service;
    private static final String NAME = "math";
    private static final String NEW_NAME = "algebra";
    private static final long WRONG_ID = 1234567L;

    @Before
    public void setUp() throws Exception {
        service = new ClassesService(repository);
    }

    @Test
    public void shouldGetClassesWhenIdIsGiven() throws Exception {
        Long classesId = givenClasses(NAME);
        ClassesDto result = service.get(classesId);
        assertEquals(NAME, result.getName());
    }

    @Test(expected = ClassesDoesNotExistException.class)
    public void shouldThrowExceptionWhenClassesIdDoesNotExist() throws Exception {
        service.get(WRONG_ID);
    }

    @Test
    public void delete() throws Exception {
        long id = givenClasses(NAME);
        service.delete(id);
        assertFalse(repository.isExists(id));
    }

    @Test
    public void update() throws Exception {
        long id = givenClasses(NAME);
        ClassesDto dto=new ClassesDto(NEW_NAME);
        service.update(id,dto);
        ClassesDto changedClasses = service.get(id);
        assertEquals(NEW_NAME,changedClasses.getName());
    }

    private Long givenClasses(String name) {
        ClassesDto dto = new ClassesDto(name);
        return service.add(dto);
    }
}