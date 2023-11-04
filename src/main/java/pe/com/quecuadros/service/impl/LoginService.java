package pe.com.quecuadros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.Data;
import pe.com.quecuadros.model.Login;
import pe.com.quecuadros.model.Usuario;
import pe.com.quecuadros.service.ILoginService;
import pe.com.quecuadros.service.IUsuarioService;

@Service
public class LoginService implements ILoginService{
	
	private @Autowired IUsuarioService usuarioService;
	private @Autowired PasswordEncoder passwordEncoder;
	
	@Override
	public Usuario validarIngreso(Login login) 
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
