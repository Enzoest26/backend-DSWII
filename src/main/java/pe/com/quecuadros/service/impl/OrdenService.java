package pe.com.quecuadros.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.Orden;
import pe.com.quecuadros.repository.IOrdenRepository;
import pe.com.quecuadros.service.IOrdenService;

@Service
@AllArgsConstructor
public class OrdenService implements IOrdenService{

	private IOrdenRepository ordenRepository;
	
	@Override
	public List<Orden> buscarTodos() {
		return this.ordenRepository.findAll();
	}
}
