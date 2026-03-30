package com.mtit.customer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Customer Service API")
                        .version("1.0.0")
                        .description("Starter Swagger configuration for the Customer microservice"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8082")
                                .description("Direct base URL: http://localhost:8082/customers"),
                        new Server()
                                .url("http://localhost:8080/api")
                                .description("Gateway base URL: http://localhost:8080/api/customers")));
    }
}
