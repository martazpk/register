package domain.model;


import domain.dto.StudentDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String surname;
    Grade grade;


    public Student(StudentDto studentDto) {
        this.name = studentDto.getName();
        this.surname = studentDto.getSurname();
        this.grade=new Grade(studentDto.getGrade());
    }
}
