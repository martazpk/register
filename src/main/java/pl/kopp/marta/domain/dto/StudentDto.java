package pl.kopp.marta.domain.dto;

public class StudentDto {
    private String name;
    private String surname;
    private String grade;


    private StudentDto(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
    }

    private StudentDto() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGrade() {
        return grade;
    }

    public static class Builder {
        private final String name;
        private final String surname;
        private String grade;

        public Builder(String name, String surname) {
            this.name=name;
            this.surname=surname;
        }

        public Builder grade(final String grade){
            this.grade=grade;
            return this;
        }

        public StudentDto build(){
            return new StudentDto(this);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
