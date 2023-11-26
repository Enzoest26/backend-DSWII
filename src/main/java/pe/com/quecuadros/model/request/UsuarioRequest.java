package pe.com.quecuadros.model.request;

import lombok.Data;

@Data
public class UsuarioRequest {
	
	private Integer id;
	
	private String direccion;
	
	private String email;
	
	private String nombre;
	
	private String password;
	
	private String telefono;
	
	private String tipoUsuario;
	
	private String username;
}
