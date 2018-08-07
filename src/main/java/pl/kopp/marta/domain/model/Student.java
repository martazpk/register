package pl.kopp.marta.domain.model;


import pl.kopp.marta.domain.dto.StudentDto;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @ManyToOne(cascade = CascadeType.ALL)
    private Grade grade;


    public Student(StudentDto studentDto) {
        this.name = studentDto.getName();
        this.surname = studentDto.getSurname();

    }

    private Student() {
    }

    public StudentDto asDto() {
        return new StudentDto.Builder(name, surname).build();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Grade getGrade() {
        return grade;
    }

    public Long getId() {
        return id;
    }

    public void update(StudentDto studentDto) {
        this.name=studentDto.getName();
        this.surname=studentDto.getSurname();
    }
}
