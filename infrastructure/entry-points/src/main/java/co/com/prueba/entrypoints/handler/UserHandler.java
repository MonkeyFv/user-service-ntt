package co.com.prueba.entrypoints.handler;

import co.com.prueba.model.user.UserRequest;
import co.com.prueba.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@RequiredArgsConstructor
public class UserHandler {
    private final UserUseCase userUseCase;

    public Mono<ServerResponse> findByUsername(ServerRequest request){
        var documentType = request.queryParam("documentType").orElse("");
        var documentNumber = request.queryParam("documentNumber").orElse("");
        var userRequest = new UserRequest(documentType, documentNumber);
        return userUseCase.findUserByDocument(userRequest)
                .flatMap(userRequestModel -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(userRequestModel))
                );
    }

}
