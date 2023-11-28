package pe.com.quecuadros.model.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UsuarioRequest {
	
	@Range(min = 0, message = "El id debe ser mayor a {min}")
	private Integer id;
	
	@NotBlank(message = "La direccion no debe ser en blanco")
	@NotNull(message = "Ingrese una dirección")
	@Length(max = 255, message ="La dirección no debe superar los {max} caracteres")
	private String direccion;
	
	@Email(message = "Debe ser un email")
	@Length(max = 255, message ="El email no debe superar los {max} caracteres")
	private String email;
	
	@NotBlank(message = "El nombre no debe ser en blanco")
	@NotNull(message = "Ingrese un nombre")
	@Length(max = 255, message ="El nombre no debe superar los {max} caracteres")
	private String nombre;
	
	@NotBlank(message = "La contraseña no debe ser en blanco.")
	@NotNull(message = "Ingrese una contraseña")
	@Length(max = 255, message ="La contraseña no debe superar los {max} caracteres")
	private String password;
	
	@NotBlank(message = "El telefono no debe ser en blanco.")
	@NotNull(message = "Ingrese una telefono")
	@Length(max = 9, message ="El telefono no debe superar los {max} caracteres")
	@Pattern(regexp = "[0-9]*", message = "El telefono debe ser numerico.")
	private String telefono;
	
	@NotBlank(message = "El Tipo Usuario no debe ser en blanco.")
	@NotNull(message = "Seleccione un Tipo Usuario")
	@Length(max = 255, message ="El Tipo Usuario no debe superar los {max} caracteres")
	private String tipoUsuario;
	
	private String username;
}
