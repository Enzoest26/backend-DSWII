package pe.com.quecuadros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.quecuadros.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{
	
	List<Producto> findFirst3ByOrderByIdProductoDesc();
}
