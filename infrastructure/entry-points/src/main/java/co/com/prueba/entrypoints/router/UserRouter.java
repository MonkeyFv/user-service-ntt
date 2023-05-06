package co.com.prueba.entrypoints.router;

import co.com.prueba.entrypoints.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Component
@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionUser(UserHandler handler){
        return route(GET("/api/v1/user"), handler::findByUsername);
    }
}
