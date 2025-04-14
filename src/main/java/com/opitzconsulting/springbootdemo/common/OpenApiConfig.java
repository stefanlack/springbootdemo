package com.opitzconsulting.springbootdemo.common;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI openAPI() {
        OpenAPI openAPI = new OpenAPI();
        openAPI
                .info(
                        new Info()
                                .title("OSCAR3 API")
                                .version("v1")
                                .description("Swagger API documentation for sprinbootdemo API")
                                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Beispiel Externe Dokumentation")
                                .url("https://github.com/stefanlack/springbootdemo/blob/main/docs/springbootdemo.md"));
        return openAPI;
    }
}
