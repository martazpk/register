package pl.kopp.marta.student.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import pl.kopp.marta.student.domain.dto.ClassesDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity
public class Classes {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "classes")
    private Set<Student> students;

    public Classes(ClassesDto dto){
        this.name=dto.getName();
        this.description=dto.getDescription();
        students = new HashSet<>();
    }

    private Classes() {
    }

    public ClassesDto asDto() {
        ModelMapper modelMapper = new ModelMapper();
        ClassesDto dto = modelMapper.map(this, ClassesDto.class);
        return dto;
    }

    public void update(ClassesDto dto){
        this.name=dto.getName();
        this.description=dto.getDescription();
    }
}
