package com.aec.fuelRoute.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Adrian E. Camus",
                        email = "acamus@tutamail.com",
                        url = "https://acamus79.github.io/"
                ),
                description = "OpenApi documentation for FuelRoute API",
                title = "Fuel routing optimization challenge  - API REST",
                version = "0.1.01",
                license = @License(
                        name = "License Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }

)
public class OpenApiConfig {
}
