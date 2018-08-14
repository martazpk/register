package pl.kopp.marta.domain.dto;

public class QueryCriteriaDto {
    private  String columnName;
    private String type;
    private  Object value;

    public QueryCriteriaDto(String columnName, String type, Object value) {
        this.columnName = columnName;
        this.type = type;
        this.value = value;
    }

    private QueryCriteriaDto() {
    }

    public String getColumnName() {
        return columnName;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }
}
