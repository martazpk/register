package repository;

import domain.model.Student;

public interface StudentRepository {
    Student get(Long id);

    boolean isExist(long id);

    void add(Student student);

    void delete(long id);

    void update(Student student);

}
