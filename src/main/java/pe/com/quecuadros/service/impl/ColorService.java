package pe.com.quecuadros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.quecuadros.model.Color;
import pe.com.quecuadros.repository.IColorRepository;
import pe.com.quecuadros.service.IColorService;

@Service
public class ColorService implements IColorService{

	@Autowired
	private IColorRepository colorRepository;
	
	@Override
	public List<Color> buscarTodos() {
		return colorRepository.findAll();
	}

}
