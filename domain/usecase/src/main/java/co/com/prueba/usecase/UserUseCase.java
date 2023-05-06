package co.com.prueba.usecase;

import co.com.prueba.model.user.DocumentType;
import co.com.prueba.model.user.UserRequest;
import co.com.prueba.model.user.UserResponse;
import co.com.prueba.model.exception.CustomException;
import co.com.prueba.model.user.gateway.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;



    public Mono<UserResponse> findUserByDocument(UserRequest request){
        if(!documentTypeValidate(request)){
            log.error("El valor del campo documentType`tiene que estar entre (C y P).");
            return Mono.error(new CustomException(HttpStatus.BAD_REQUEST,"El valor del campo documentType`tiene que estar entre (C y P)."));
        }
        return userRepository.findByUser(request);
    }

    public boolean documentTypeValidate(UserRequest request) {
        var documentType = request.getDocumentType();
        return Arrays.stream(DocumentType.values())
                .map(Enum::name)
                .anyMatch(colorName -> colorName.equalsIgnoreCase(documentType));
    }

}