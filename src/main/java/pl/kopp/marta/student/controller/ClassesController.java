package pl.kopp.marta.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kopp.marta.student.domain.dto.ClassesDto;
import pl.kopp.marta.student.domain.service.ClassesService;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    private final ClassesService service;

    @Autowired
    public ClassesController(ClassesService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public long save(@ModelAttribute ClassesDto dto){return service.add(dto);}

    @RequestMapping(path = "/{identifier}",method = RequestMethod.GET)
    public ClassesDto get(@PathVariable long identifier){
        return service.get(identifier);
    }

    @RequestMapping(path = "/{identifier}",method = RequestMethod.DELETE)
    public void delete(@PathVariable long identifier){
        service.delete(identifier);
    }

    @RequestMapping(path = "/{identifier}",method = RequestMethod.PUT)
    public void update(@PathVariable long identifier,@ModelAttribute ClassesDto dto){
        service.update(identifier,dto);
    }
}
