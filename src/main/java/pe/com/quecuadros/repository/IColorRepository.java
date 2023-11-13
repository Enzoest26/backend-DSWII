package pe.com.quecuadros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.quecuadros.model.Color;

public interface IColorRepository extends JpaRepository<Color, Integer>{

}
