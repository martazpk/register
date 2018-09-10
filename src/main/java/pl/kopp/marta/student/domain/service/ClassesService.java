package pl.kopp.marta.student.domain.service;

import org.springframework.stereotype.Service;
import pl.kopp.marta.student.domain.dto.ClassesDto;
import pl.kopp.marta.student.domain.model.Classes;
import pl.kopp.marta.student.domain.service.exceptions.ClassesDoesNotExistException;
import pl.kopp.marta.student.repository.ClassRepository;

@Service
public class ClassesService {
    private final ClassRepository repository;

    public ClassesService(ClassRepository repository) {
        this.repository = repository;
    }

    public ClassesDto get(long id) {
        if (repository.isExists(id)) {
            return repository.get(id).asDto();
        } else throw new ClassesDoesNotExistException(id);
    }

    public long add(ClassesDto dto) {
        Classes classes = new Classes(dto);
        repository.add(classes);
        return classes.getId();
    }

    public void delete(long id) {
        if (repository.isExists(id)) {
            repository.delete(id);
        } else throw new ClassesDoesNotExistException(id);
    }

    public void update(long id, ClassesDto dto) {
        if (repository.isExists(id)) {
            Classes classes = repository.get(id);
            classes.update(dto);
            repository.add(classes);
        } else throw new ClassesDoesNotExistException(id);
    }
}
