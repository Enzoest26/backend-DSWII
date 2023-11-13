package pe.com.quecuadros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.quecuadros.model.Material;
import pe.com.quecuadros.repository.IMaterialRepository;
import pe.com.quecuadros.service.IMaterialService;

@Service
public class MaterialService implements IMaterialService {

	@Autowired
	private IMaterialRepository materialRepository;
	
	@Override
	public List<Material> buscarTodos() {
		return materialRepository.findAll();
	}

}
