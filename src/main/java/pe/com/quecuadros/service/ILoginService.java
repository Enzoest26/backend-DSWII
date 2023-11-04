package pe.com.quecuadros.service;

import pe.com.quecuadros.model.Login;
import pe.com.quecuadros.model.Usuario;

public interface ILoginService {
	
	public Usuario validarIngreso(Login login);
}
