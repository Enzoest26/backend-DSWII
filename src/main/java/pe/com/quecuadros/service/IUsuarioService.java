package pe.com.quecuadros.service;

import java.util.List;

import org.springframework.data.domain.Page;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> buscarTodos();
		
	public Usuario buscarPorId(Integer id);
	
	public Page<Usuario> buscarPorPaginado(Integer pagina);
	
	public List<Usuario> buscarPorUsername(String username);
	
	public List<Usuario> buscarPorEmail(String email);
	
	public Usuario registrarUsuario(Usuario usuario);
	
	public BaseResponse actualizarUsuario(Usuario usuario);
	
	public BaseResponse eliminarUsuario(Integer id);
}
