package pl.kopp.marta.student.domain.model;



import pl.kopp.marta.student.domain.dto.StudentDto;

import javax.persistence.*;

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

    public Contact getContact() {
        return contact;
    }
}
