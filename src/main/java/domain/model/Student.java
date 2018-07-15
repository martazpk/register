package domain.model;


import domain.dto.StudentDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    Long pesel;
    String name;
    String surname;
    Grade grade;


    public Student(StudentDto studentDto) {
        this.name = studentDto.getName();
        this.surname = studentDto.getSurname();
        this.grade=new Grade(studentDto.getGrade());
    }

    public StudentDto asDto() {
        return new StudentDto(name,surname,grade.getName(),pesel);
    }

    public Long getPesel() {
        return pesel;
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
}
