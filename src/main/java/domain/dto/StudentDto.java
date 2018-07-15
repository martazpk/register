package domain.dto;

public class StudentDto {
    String name;
    String surname;
    String grade;


    public StudentDto(String name, String surname, String grade) {
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
