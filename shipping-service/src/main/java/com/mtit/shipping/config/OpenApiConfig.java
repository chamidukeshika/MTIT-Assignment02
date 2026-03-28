package com.mtit.shipping.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI shippingOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Shipping Service API")
                        .version("1.0.0")
                        .description("Starter Swagger configuration for the Shipping microservice"));
    }
}
