package pe.com.quecuadros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.Usuario;
import pe.com.quecuadros.model.request.UsuarioRequest;
import pe.com.quecuadros.repository.IUsuarioRepository;
import pe.com.quecuadros.service.IUsuarioService;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService
{
	private IUsuarioRepository usuarioRepository;
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Usuario> buscarTodos() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> buscarPorId(Integer id) {
		return this.usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> buscarPorUsername(String username) {
		return this.usuarioRepository.findByUsername(username);
	}

	@Override
	public Usuario registrarUsuario(UsuarioRequest request) 
	{
		Usuario usuario = new Usuario();
		usuario.setDireccion(request.getDireccion());
		usuario.setEmail(request.getEmail());
		usuario.setNombre(request.getNombre());
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setTipoUsuario(request.getTipoUsuario());
		usuario.setUsername(request.getUsername());
		usuario.setTelefono(request.getTelefono());
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> actualizarUsuario(UsuarioRequest request) {
		return this.usuarioRepository.findById(request.getId()).map(usuario -> {
			usuario.setDireccion(request.getDireccion());
			usuario.setEmail(request.getEmail());
			usuario.setNombre(request.getNombre());
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuario.setTipoUsuario(request.getTipoUsuario());
			usuario.setUsername(request.getUsername());
			usuario.setTelefono(request.getTelefono());
			return this.usuarioRepository.save(usuario);
		});
	}

	@Override
	public void eliminarUsuario(Integer id) {
		this.usuarioRepository.deleteById(id);
	}

	@Override
	public List<Usuario> buscarPorEmail(String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	@Override
	public Page<Usuario> buscarPorPaginado(Integer pagina) 
	{
		Pageable paginado = PageRequest.of(pagina - 1, 10);
		return this.usuarioRepository.findAll(paginado);
	}


}
