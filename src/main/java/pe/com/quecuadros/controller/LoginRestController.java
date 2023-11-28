package pe.com.quecuadros.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.Usuario;
import pe.com.quecuadros.model.request.LoginRequest;
import pe.com.quecuadros.service.ILoginService;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Tag(name = "Login Controller", description = "Controlador de Login")
public class LoginRestController {

	private ILoginService loginService;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody @Valid LoginRequest login)
	{
		Usuario usuario = this.loginService.validarIngreso(login);
		if(usuario == null)
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		else
			return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
}
