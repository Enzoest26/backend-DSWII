package pe.com.quecuadros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.quecuadros.model.Orden;


public interface IOrdenRepository extends JpaRepository<Orden, Integer>{
	
	List<Orden> findTopByOrderByIdDesc();
}
