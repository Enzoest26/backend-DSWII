package pe.com.quecuadros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.Material;
import pe.com.quecuadros.repository.IMaterialRepository;
import pe.com.quecuadros.service.IMaterialService;

@Service
@AllArgsConstructor
public class MaterialService implements IMaterialService {

	private IMaterialRepository materialRepository;
	
	@Override
	public List<Material> buscarTodos() {
		return materialRepository.findAll();
	}

	@Override
	public Optional<Material> buscarPorId(Integer id) {
		return materialRepository.findById(id);
	}

}
