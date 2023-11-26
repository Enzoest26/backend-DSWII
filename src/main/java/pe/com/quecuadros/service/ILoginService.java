package pe.com.quecuadros.service;

import pe.com.quecuadros.model.Usuario;
import pe.com.quecuadros.model.request.LoginRequest;

public interface ILoginService {
	
	public Usuario validarIngreso(LoginRequest login);
}
