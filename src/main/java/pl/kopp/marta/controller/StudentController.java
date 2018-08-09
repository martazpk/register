package pl.kopp.marta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kopp.marta.domain.dto.StudentDto;
import pl.kopp.marta.domain.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public long create(@ModelAttribute StudentDto dto) {
        return service.add(dto);
    }

    @RequestMapping(path = "/{identifier}", method = RequestMethod.DELETE)
    public void remove(@PathVariable long identifier){
        service.delete(identifier);
    }

    @RequestMapping(path = "/{identifier}", method = RequestMethod.GET)
    public StudentDto get(@PathVariable long identifier){
        return service.get(identifier);
    }

    @RequestMapping(path = "/{identifier}",method = RequestMethod.POST)
    public void update(@PathVariable long identifier, @ModelAttribute StudentDto dto){
        service.update(identifier,dto);
    }
}
