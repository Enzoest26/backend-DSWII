package pe.com.quecuadros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.quecuadros.exception.ItemNoEncontradoException;
import pe.com.quecuadros.model.Login;
import pe.com.quecuadros.model.Usuario;
import pe.com.quecuadros.service.ILoginService;

@RestController
@RequestMapping("/")
public class LoginRestController {

	private @Autowired ILoginService loginService;
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Login login)
	{
		Usuario usuario = this.loginService.validarIngreso(login);
		if(usuario != null)
			return usuario;
		throw new ItemNoEncontradoException("Usuario y/o contraseña incorrectos.");
	}
}
