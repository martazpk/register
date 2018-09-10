package pl.kopp.marta.student.repository;

import pl.kopp.marta.student.domain.model.Classes;

public interface ClassRepository {
    Classes get(long id);
    void delete(long id);
    void update(Classes classes);
    void add(Classes classes);
    boolean isExists(long id);
}
