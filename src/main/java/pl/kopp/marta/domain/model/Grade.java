package pl.kopp.marta.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private long id;
    private int level;
    private char name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    private Grade() {
    }

    public Grade(int level, char name) {
        this.level = level;
        this.name = name;
    }


    public String getGrade() {
        return String.valueOf(level) + String.valueOf(name);
    }

    public long getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public char getName() {
        return name;
    }
}
