package pl.kopp.marta.student.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryCriteriaDto {
    private String columnName;
    private String type;
    private String value;

    public QueryCriteriaDto(String columnName, String type, String value) {
        this.columnName = columnName;
        this.type = type;
        this.value = value;
    }

    private QueryCriteriaDto() {
    }

}
