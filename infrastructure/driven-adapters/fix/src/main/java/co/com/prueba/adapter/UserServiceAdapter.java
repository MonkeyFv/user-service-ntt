package co.com.prueba.adapter;

import co.com.prueba.model.user.UserRequest;
import co.com.prueba.model.user.UserResponse;
import co.com.prueba.model.exception.CustomException;
import co.com.prueba.model.user.gateway.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

@Log4j2
public class UserServiceAdapter implements UserRepository {

    public static final String USER = "23445322";
    public static final String CEDULA_CIUDADANIA = "C";

    @Override
    public Mono<UserResponse> findByUser(UserRequest request) {
        if (!varlidarSiExisteUsuarioUsuario(request)){
            log.error("No existe el usuario");
            return Mono.error(new CustomException(HttpStatus.NOT_FOUND,"No existe el usuario."));
        }
        log.info("El usuario fue encontrado exitosamente");
        return Mono.just(getUserResponse());
    }

    private boolean varlidarSiExisteUsuarioUsuario(UserRequest request) {
        return request.getDocumentNumber().equals(USER) && request.getDocumentType().equals(CEDULA_CIUDADANIA);
    }

    private UserResponse getUserResponse() {
        return UserResponse
                .builder()
                .firstName("Brayan")
                .secondName("Fabian")
                .firstLastName("Vargas")
                .secondLastName("Bermudez")
                .phone("3144020583")
                .address("Calle falsa 123")
                .residenceCity("Soacha")
                .build();
    }
}
