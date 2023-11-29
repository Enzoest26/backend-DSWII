package pe.com.quecuadros.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.quecuadros.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	List<Usuario> findByUsername(String username);
	
	Optional<Usuario> findByEmail(String email);
}
