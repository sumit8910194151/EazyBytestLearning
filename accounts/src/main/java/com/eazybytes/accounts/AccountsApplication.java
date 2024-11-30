package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing//to enable JPA auditing
@OpenAPIDefinition(
		info=@Info(
				title="Accounts Microservice Rest API documentation",
				description = "Eazy bank Accounts microservce rest apis",
				version = "v1",
				contact=@Contact(
						name="Sumit Singh",
						email = "mailmeatsumitsingh@gmailcom",
						url="https://sumitsingh.in"
				),
				license = @License(
						name="Apache 2.0",
						url="https://sumitsingh.in"
				)
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}


}
