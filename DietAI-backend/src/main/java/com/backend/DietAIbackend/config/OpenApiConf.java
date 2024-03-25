package com.backend.DietAIbackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

/*
http://localhost:8080/v3/api-docs
http://localhost:8080/swagger-ui/index.html
 */
@Configuration
public class OpenApiConf {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info()
                        .title("DietAI API")
                        .description("API de Ana y Jose los mejores del mundo")
                        .version("Version 0.0.1")
                );
    }
}
