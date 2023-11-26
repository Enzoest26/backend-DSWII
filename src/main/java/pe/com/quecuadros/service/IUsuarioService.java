package pe.com.quecuadros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import pe.com.quecuadros.model.Usuario;
import pe.com.quecuadros.model.request.UsuarioRequest;

public interface IUsuarioService {
	
	public List<Usuario> buscarTodos();
		
	public Optional<Usuario> buscarPorId(Integer id);
	
	public Page<Usuario> buscarPorPaginado(Integer pagina);
	
	public List<Usuario> buscarPorUsername(String username);
	
	public List<Usuario> buscarPorEmail(String email);
	
	public Usuario registrarUsuario(UsuarioRequest usuario);
	
	public Optional<Usuario> actualizarUsuario(UsuarioRequest usuario);
	
	public void eliminarUsuario(Integer id);
}
