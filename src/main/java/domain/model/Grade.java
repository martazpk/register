package domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    Long id;
    String name;
    Student[] students;

    public Grade(String name) {
        this.name = name;
    }
}
