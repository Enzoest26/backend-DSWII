package pe.com.quecuadros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.quecuadros.model.Material;

public interface IMaterialRepository extends JpaRepository<Material, Integer>{

}
