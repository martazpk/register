package pl.kopp.marta.student.domain.model;

import pl.kopp.marta.student.domain.model.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private long id;
    private int level;
    private String name;
    @OneToMany(mappedBy = "grade",cascade = CascadeType.ALL)
    private Set<Student> students;

    private Grade() {
    }

    public Grade(int level, String name) {
        this.students = new HashSet<>();
        this.level = level;
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String value() {
        return String.valueOf(level) + name;
    }

    public long getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
