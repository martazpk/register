package pl.kopp.marta.student.controller;

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
    public static final String NAME="Peter";
    public static final String NEW_NAME="Spider-man";
    public static final String SURNAME="Parker";
    public static final long WRONG_ID=123455L;

    @Autowired
    private MockMvc chrome;
    @Autowired
    private StudentService service;

    @Test
    public void shouldCreateNewStudent() throws Exception {
        MockHttpServletResponse response=chrome.perform(MockMvcRequestBuilders.post("/student")
        .param("name",NAME)
        .param("surname",SURNAME)).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        String id = response.getContentAsString();
        MockHttpServletResponse create = aStudentBy(Long.valueOf(id));
        assertEquals("{\"name\":\""+NAME+"\",\"surname\":\"" + SURNAME+"\",\"grade\":null}",create.getContentAsString());

    }

    @Test
    public void remove() throws Exception {
        long id=givenStudent(NAME,SURNAME);

        MockHttpServletResponse response=chrome.perform(MockMvcRequestBuilders.delete("/student/{id}",id))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void shouldGet() throws Exception {
        long id=givenStudent(NAME,SURNAME);

        MockHttpServletResponse response=aStudentBy(id);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"name\":\""+NAME+"\",\"surname\":\"" + SURNAME+"\",\"grade\":null}", response.getContentAsString());
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
        long id=givenStudent(NAME,SURNAME);

        MockHttpServletResponse response=chrome.perform(MockMvcRequestBuilders
                .put("/student/{id}",id)
        .param("name",NEW_NAME)
        .param("surname",SURNAME)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        MockHttpServletResponse create=aStudentBy(id);
        assertEquals("{\"name\":\""+NEW_NAME+"\",\"surname\":\"" + SURNAME+"\",\"grade\":null}", create.getContentAsString());
    }

    @Test
    public void shouldReturnNotFoundStatusWhenStudentDoesNotExists() throws Exception {
        MockHttpServletResponse response=aStudentBy(WRONG_ID);

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }
}