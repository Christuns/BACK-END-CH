package br.edu.unipaulista.backend.Blog.ifrastructure;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

// @Configurantion
public class OpenApiConfig {

    // @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API example : Blog")
                        .version("1.0")
                        .description("o que o programa vai fazer")
                );
    }
}
