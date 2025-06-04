package br.com.fiap.global_solution.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Gestão Abrigos FIAP 2025")
                        .description("API para gerenciamento de abrigos, localizações e recursos em situações de emergência")
                        .version("v1.0")
                        .contact(new Contact().name("Equipe FIAP").email("contato@fiap.com.br"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
