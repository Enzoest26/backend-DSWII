package pe.com.quecuadros.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
	
	@NotNull(message = "Ingrese un correo electronico")
	@NotBlank(message = "El correo electronico no debe estar en blanco")
	@Email(message = "El correo electronico es invalido")
	private String username;
	
	@NotNull(message = "Ingrese una contraseña")
	@NotBlank(message = "La contraseña no debe estar en blanco")
	private String contrasenia;
}
