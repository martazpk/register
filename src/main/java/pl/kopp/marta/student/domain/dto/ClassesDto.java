package pl.kopp.marta.student.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassesDto {
    private String name;
    private String description;

    public ClassesDto(String name) {
        this.name = name;
    }

    private ClassesDto() {
    }
}
