package pe.com.quecuadros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.quecuadros.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByUsername(String username);
	
	List<Usuario> findByEmail(String email);
}
