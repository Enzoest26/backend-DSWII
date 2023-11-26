package pe.com.quecuadros.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
			title = "API Quecuadros",
			version = "1.0",
			description =  "API de la aplicación Quecuadros",
			contact = @Contact(email = "desarrollo@quecuardo.com.pe", name = "Equipo Desarrollo")),
		servers = {
			@Server(url = "http://localhost:8080", description = "Desarrollo")
		}
	)
public class OpenApiConfiguration {

}
