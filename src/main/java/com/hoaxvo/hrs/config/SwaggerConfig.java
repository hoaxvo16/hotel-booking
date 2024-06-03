package com.hoaxvo.hrs.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class SwaggerConfig {
    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public OpenAPI openAPI() {
        OpenAPI openAPI = new OpenAPI();
        Info info = new Info();
        info.setTitle(appName);
        Components components = new Components();
        components.addSecuritySchemes(HttpHeaders.AUTHORIZATION,
                new SecurityScheme().name("basicAuth").type(SecurityScheme.Type.HTTP).scheme("basic"));
        openAPI.addSecurityItem(new SecurityRequirement().addList(HttpHeaders.AUTHORIZATION));
        openAPI.setComponents(components);
        openAPI.setInfo(info);
        return openAPI;
    }
}
