package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.framework.spring.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
@Configuration
public class SpringDocConfig {

    @Value("${application.version}")
    private String version;
    @Value("${application.description}")
    private String description;
    @Value("${application.title}")
    private String title;
    @Value("${application.license}")
    private String license;
    @Value("${application.terms}")
    private String terms;
    @Value("${application.url-License}")
    private String urlLicense;
    @Value("${information.name}")
    private String name;
    @Value("${information.email}")
    private String email;
    @Value("${information.url}")
    private String urlInformation;

    @Bean
    public OpenAPI openAPIConfig(){
        return new OpenAPI()
                .info(new Info()
                        .contact(new Contact()
                                .name(this.name)
                                .email(this.email)
                                .url(this.urlInformation)
                        )
                        .title(this.title)
                        .version(this.version)
                        .description(this.description)
                        .termsOfService(this.terms)
                        .license(new License()
                                .name(this.license)
                                .url(this.urlLicense)));
    }

}