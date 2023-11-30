package pe.com.quecuadros.service;

import java.util.List;
import java.util.Optional;

import pe.com.quecuadros.model.Color;

public interface IColorService {
	public List<Color> buscarTodos();
	public Optional<Color> buscarPorId(Integer id);
}
