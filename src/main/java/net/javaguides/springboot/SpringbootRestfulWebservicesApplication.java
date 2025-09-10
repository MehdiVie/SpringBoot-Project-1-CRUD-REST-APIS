package net.javaguides.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot API Documentation",
                description = "Spring Boot API Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Mehdi",
                        email = "salimimehdibeti00@gmail.com",
                        url = "http://localhost:9090/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://localhost:9090/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
        description = "Spring Boot User Management Documentation",
        url = "http://localhost:9090/user_management.html"
        )
)
public class SpringbootRestfulWebservicesApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
