package pe.com.quecuadros.service;

import java.util.List;
import java.util.Optional;

import pe.com.quecuadros.model.Material;

public interface IMaterialService {
	public  List<Material> buscarTodos();
	public Optional<Material> buscarPorId(Integer id);
}
