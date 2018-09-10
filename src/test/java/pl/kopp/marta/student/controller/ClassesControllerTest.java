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
import pl.kopp.marta.student.domain.dto.ClassesDto;
import pl.kopp.marta.student.domain.service.ClassesService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClassesControllerTest {
    public static final String NAME = "Math";
    public static final String NEW_NAME = "Algebra";
    public static final long WRONG_ID=44444444L;


    @Autowired
    private MockMvc chrome;
    @Autowired
    private ClassesService service;

    @Test
    public void shouldCreateNewClasses() throws Exception {
        MockHttpServletResponse response = chrome.perform(MockMvcRequestBuilders.post("/classes")
                .param("name", NAME)).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String id = response.getContentAsString();
        MockHttpServletResponse create = aClassesBy(Long.valueOf(id));
        assertEquals("{\"name\":\"" + NAME + "\",\"description\":null}", create.getContentAsString());
    }

    private MockHttpServletResponse aClassesBy(Long id) throws Exception {
        return chrome.perform(MockMvcRequestBuilders.get("/classes/{id}", id)).andReturn().getResponse();
    }

    @Test
    public void shouldGetClasses() throws Exception {
        long id=givenClasses(NAME);
        MockHttpServletResponse response=aClassesBy(id);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("{\"name\":\"" + NAME + "\",\"description\":null}", response.getContentAsString());
    }

    private long givenClasses(String name) {
        ClassesDto initialDto=new ClassesDto(name);
        return service.add(initialDto);
    }

    @Test
    public void delete() throws Exception {
        long id=givenClasses(NAME);

        MockHttpServletResponse response=chrome.perform(MockMvcRequestBuilders.delete("/classes/{id}",id))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void update() throws Exception {
        long id=givenClasses(NAME);
        MockHttpServletResponse response=chrome.perform(MockMvcRequestBuilders
                .put("/classes/{id}",id)
                .param("name",NEW_NAME)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        MockHttpServletResponse create=aClassesBy(id);
        assertEquals("{\"name\":\"" + NEW_NAME + "\",\"description\":null}", create.getContentAsString());
    }

    @Test
    public void shouldReturnNotFoundStatusWhenClassesDoesNotExist() throws Exception {
        MockHttpServletResponse response=aClassesBy(WRONG_ID);

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }
}