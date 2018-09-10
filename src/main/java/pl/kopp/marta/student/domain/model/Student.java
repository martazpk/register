package pl.kopp.marta.student.domain.model;


import lombok.Getter;
import lombok.Setter;
import pl.kopp.marta.student.domain.dto.StudentDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Grade grade;
    @Embedded
    private Contact contact;
    @ManyToMany
    private Set<Classes> classes;

    public Student(StudentDto studentDto) {
        this.name = studentDto.getName();
        this.surname = studentDto.getSurname();
        this.classes =new HashSet<>();
    }

    private Student() {
    }

    public StudentDto asDto() {
        return new StudentDto.Builder(name, surname).build();
    }

    public String getName() {
        return name;
    }


    public void update(StudentDto studentDto) {
        this.name = studentDto.getName();
        this.surname = studentDto.getSurname();
    }

    public void addClass(Classes classes){
        this.classes.add(classes);
    }

}
