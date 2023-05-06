package co.com.prueba.model.user;

import lombok.*;

@ToString
@NoArgsConstructor
public enum DocumentType {
    P("PASAPORTE"),
    C("CEDULA DE CIUDADANIA");

    private String value;

    private DocumentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
