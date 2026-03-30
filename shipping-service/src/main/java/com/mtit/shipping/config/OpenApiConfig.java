package com.mtit.shipping.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI shippingOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Shipping Service API")
                        .version("1.0.0")
                        .description("Starter Swagger configuration for the Shipping microservice"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8086")
                                .description("Direct base URL: http://localhost:8086/shipping"),
                        new Server()
                                .url("http://localhost:8080/api")
                                .description("Gateway base URL: http://localhost:8080/api/shipping")));
    }
}
