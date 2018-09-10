package pl.kopp.marta.student.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
