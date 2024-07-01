package com.example.msdocumentodetesis;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsDocumentodeTesisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsDocumentodeTesisApplication.class, args);
    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("OPEN API MICROSERVICIO DOCUMENTODETESIS")
                .version("0.0.1")
                .description("servicios web documento tesis")
                .termsOfService("http:// swagger.io/terms")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
        );
    }

}
