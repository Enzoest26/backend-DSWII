package pe.com.quecuadros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.com.quecuadros.exception.ItemNoEncontradoException;
import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.Usuario;
import pe.com.quecuadros.repository.IUsuarioRepository;
import pe.com.quecuadros.service.IUsuarioService;
import pe.com.quecuadros.util.ConstantesGenerales;

@Service
public class UsuarioService implements IUsuarioService
{
	private @Autowired IUsuarioRepository usuarioRepository;
	private @Autowired PasswordEncoder passwordEncoder;
	
	@Override
	public List<Usuario> buscarTodos() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		return this.usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> buscarPorUsername(String username) {
		return this.usuarioRepository.findByUsername(username);
	}

	@Override
	public Usuario registrarUsuario(Usuario usuario) 
	{
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public BaseResponse actualizarUsuario(Usuario usuario) {
		if(this.usuarioRepository.existsById(usuario.getId()))
		{
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			this.usuarioRepository.save(usuario);
			return BaseResponse.builder()
					.codRespuesta(ConstantesGenerales.CODIGO_EXITO)
					.mensajeRespuesta(ConstantesGenerales.MENSAJE_ACTUALIZACION_EXITO)
					.build();
		}
		else {
			throw new ItemNoEncontradoException(ConstantesGenerales.USUARIO_NO_ENCONTRADO);
		}
		
	}

	@Override
	public BaseResponse eliminarUsuario(Integer id) {
		if(this.usuarioRepository.existsById(id))
		{
			this.usuarioRepository.deleteById(id);
			return BaseResponse.builder()
					.codRespuesta(ConstantesGenerales.CODIGO_EXITO)
					.mensajeRespuesta(ConstantesGenerales.MENSAJE_ELIMINACION_EXITO)
					.build();
		}
		else {
			throw new ItemNoEncontradoException(ConstantesGenerales.USUARIO_NO_ENCONTRADO);
		}
	}

	@Override
	public List<Usuario> buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findByEmail(email);
	}

}
