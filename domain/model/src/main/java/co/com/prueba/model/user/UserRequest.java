package co.com.prueba.model.user;


import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String documentType;
    private String documentNumber;

}
