package com.backend.DietAIbackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
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
        // Define el esquema de seguridad con tipo bearer token
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        // Configura el flujo de autenticación
        OAuthFlows flows = new OAuthFlows()
                .password(new OAuthFlow().tokenUrl("/oauth/token"));

        // Agrega el esquema de seguridad a las operaciones protegidas
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

        // Define la configuración de Swagger
        return new OpenAPI()
                .info(new Info()
                        .title("DietAI API")
                        .description("API de Ana y Jose los mejores del mundo")
                        .version("Version 0.0.1")
                )
                .addSecurityItem(securityRequirement)
                .components(new io.swagger.v3.oas.models.Components().addSecuritySchemes("bearerAuth", securityScheme));
    }
}

