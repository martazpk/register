package domain.dto;

public class StudentDto {
    String name;
    String surname;
    String grade;
    Long pesel;


    public StudentDto(String name, String surname, String grade,Long pesel) {
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.pesel=pesel;
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

    public Long getPesel() {
        return pesel;
    }
}
