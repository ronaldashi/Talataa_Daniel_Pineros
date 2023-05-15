package com.danielpineros.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuración de Swagger para generar documentación de la API.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configura el bean Docket para Swagger.
     *
     * @return Docket configurado
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.danielpineros.Controller")) // Paquete base para escanear los controladores
                .paths(PathSelectors.any()) // Selecciona todos los endpoints
                .build()
                .apiInfo(createMetaData()); // Información de la API
    }

    /**
     * Crea la información de la API para Swagger UI.
     *
     * @return ApiInfo creada
     */
    private ApiInfo createMetaData() {
        return new ApiInfoBuilder()
                .title("Talataa REST API") // Título de la API
                .description("API diseñada para el uso de Swagger UI con The Movie DB") // Descripción de la API
                .version("1.0.0") // Versión de la API
                .build();
    }
}
