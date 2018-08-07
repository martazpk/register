package pl.kopp.marta.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private long id;
    private int number;
    private char name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    private Grade() {
    }

    public Grade(int number, char name) {
        this.number = number;
        this.name = name;
    }


    public String getGrade() {
        return String.valueOf(number) + String.valueOf(name);
    }

    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public char getName() {
        return name;
    }
}
