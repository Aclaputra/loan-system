package com.investree.sandboxing.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Transkasi API",
//                version = "${api.version}",
                version = "v.1.0.0",
                contact = @Contact(
                        name = "Muhammad Acla", email = "acla@gmail.com", url = "http://localhost:8081"
                ),
                license = @License(
                        name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                termsOfService = "${tos.uri}",
//                description = "${api.description}"
                description = "Transaksi API CRUD Operation"
        ),
        servers = @Server(
                url = "http://localhost:8081/api",
                description = "Production"
        )
)
public class OpenAPISecurityConfiguration {

}
