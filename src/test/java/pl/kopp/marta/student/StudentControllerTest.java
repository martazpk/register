package pl.kopp.marta.student;

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
import pl.kopp.marta.student.domain.service.StudentService;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc chrome;
    @Autowired
    private StudentService service;

    @Test
    public void create() throws Exception {
        String name="Peter";
        String surname="Parker";
        MockHttpServletResponse response=chrome.perform(MockMvcRequestBuilders.post("/student")
        .param("name",name)
        .param("surname",surname)).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        String id = response.getContentAsString();
        MockHttpServletResponse create = aStudentBy(Long.valueOf(id));
        assertEquals("{\"name\":\""+name+"\",\"surname\":\"" + surname+"\",\"grade\":null}",create.getContentAsString());

    }

    @Test
    public void remove() throws Exception {
        String name="Peter";
        String surname="Parker";
        long id=givenStudent(name,surname);

        MockHttpServletResponse response=chrome.perform(MockMvcRequestBuilders.delete("/student/{id}",id))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void shouldGet() throws Exception {
        String name="Peter";
        String surname="Parker";
        long id=givenStudent(name,surname);

        MockHttpServletResponse response=aStudentBy(id);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"name\":\""+name+"\",\"surname\":\"" + surname+"\",\"grade\":null}", response.getContentAsString());
    }

    private MockHttpServletResponse aStudentBy(long id) throws Exception {
        return chrome.perform(MockMvcRequestBuilders.get("/student/{id}",id)).andReturn().getResponse();
    }

    private long givenStudent(String name, String surname) {
        StudentDto dto=new StudentDto.Builder(name,surname).build();
        return service.add(dto);
    }

    @Test
    public void update() throws Exception {
        String name="Peter";
        String newName="Spider-man";
        String surname="Parker";
        long id=givenStudent(name,surname);

        MockHttpServletResponse response=chrome.perform(MockMvcRequestBuilders
                .put("/student/{id}",id)
        .param("name",newName)
        .param("surname",surname)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        MockHttpServletResponse create=aStudentBy(id);
        assertEquals("{\"name\":\""+newName+"\",\"surname\":\"" + surname+"\",\"grade\":null}", create.getContentAsString());
    }

    @Test
    public void shouldReturnNotFoundStatusWhenStudentDoesNotExists() throws Exception {
        long wrongId=111L;
        MockHttpServletResponse response=aStudentBy(wrongId);

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }
}