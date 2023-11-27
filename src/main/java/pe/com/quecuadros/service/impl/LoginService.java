package pe.com.quecuadros.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.Usuario;
import pe.com.quecuadros.model.request.LoginRequest;
import pe.com.quecuadros.service.ILoginService;
import pe.com.quecuadros.service.IUsuarioService;

@Service
@AllArgsConstructor
public class LoginService implements ILoginService{
	
	private IUsuarioService usuarioService;
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Usuario validarIngreso(LoginRequest login) 
	{
		List<Usuario> usuarios = this.usuarioService.buscarPorEmail(login.getUsername());
		if(!usuarios.isEmpty())
		{
			return this.passwordEncoder.matches( login.getContrasenia(),usuarios.get(0).getPassword()) ? 
					usuarios.get(0) : null;
		}
		return null;
	}

}
