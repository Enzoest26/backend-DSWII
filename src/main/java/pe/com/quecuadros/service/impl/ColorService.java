package pe.com.quecuadros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.Color;
import pe.com.quecuadros.repository.IColorRepository;
import pe.com.quecuadros.service.IColorService;

@Service
@AllArgsConstructor
public class ColorService implements IColorService{

	private IColorRepository colorRepository;
	
	@Override
	public List<Color> buscarTodos() {
		return colorRepository.findAll();
	}

	@Override
	public Optional<Color> buscarPorId(Integer id) {
		return this.colorRepository.findById(id);
	}

}
