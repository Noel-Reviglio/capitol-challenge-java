package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.framework.spring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public OpenAPI openAPIConfig(){
        return new OpenAPI()
                .info( new Info()
                        .title(this.title)
                        .version(this.version)
                        .description(this.description)
                        .termsOfService(this.terms)
                        .license( new License()
                                .name(this.license)
                                .url(this.urlLicense)));
    }
}
