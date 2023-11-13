package pe.com.quecuadros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.Usuario;
import pe.com.quecuadros.service.IUsuarioService;

@RequestMapping("/usuario")
@RestController
public class UsuarioRestController {
	
	private @Autowired IUsuarioService usuarioService;
	
	@GetMapping("/listarTodos")
	public List<Usuario> buscarTodos()
	{
		return this.usuarioService.buscarTodos();
	}
	
	@GetMapping("/buscarPorId/{id}")
	public Usuario buscarPorId(@PathVariable Integer id)
	{
		return this.usuarioService.buscarPorId(id);
	}
	
	@PostMapping("/registrar")
	public Usuario registrarUsuario(@RequestBody Usuario usuario)
	{
		return this.usuarioService.registrarUsuario(usuario);
	}
	
	@PutMapping("/actualizar")
	public BaseResponse actualizarUsuario(@RequestBody Usuario usuario)
	{
		return this.usuarioService.actualizarUsuario(usuario);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public BaseResponse actualizarUsuario(@PathVariable Integer id)
	{
		return this.usuarioService.eliminarUsuario(id);
	}
}
