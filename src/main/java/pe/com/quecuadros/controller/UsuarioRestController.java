package pe.com.quecuadros.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.request.UsuarioRequest;
import pe.com.quecuadros.service.IUsuarioService;

@RequestMapping("/usuarios")
@RestController
@AllArgsConstructor
@Tag(name = "Usuarios Controller", description = "Controlador de Usuarios")
public class UsuarioRestController {
	
	private IUsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<?> buscarTodos()
	{
		return new ResponseEntity<>(this.usuarioService.buscarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id)
	{
		return ResponseEntity.of(this.usuarioService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> registrarUsuario(@RequestBody @Valid UsuarioRequest request)
	{
		return new ResponseEntity<>(this.usuarioService.registrarUsuario(request), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> actualizarUsuario(@RequestBody @Valid UsuarioRequest request)
	{
		return ResponseEntity.of(this.usuarioService.actualizarUsuario(request));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void eliimnarUsuario(@PathVariable Integer id)
	{
		this.usuarioService.eliminarUsuario(id);
	}
	
	@GetMapping("/email")
	public ResponseEntity<?> buscarPorEmail(@RequestParam String email)
	{
		return ResponseEntity.of(this.usuarioService.buscarPorEmail(email));
	}
	
	
}
