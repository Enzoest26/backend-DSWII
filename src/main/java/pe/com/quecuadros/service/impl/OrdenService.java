package pe.com.quecuadros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.quecuadros.model.Orden;
import pe.com.quecuadros.repository.IOrdenRepository;
import pe.com.quecuadros.service.IOrdenService;

@Service
public class OrdenService implements IOrdenService{

	private @Autowired IOrdenRepository ordenRepository;
	
	@Override
	public List<Orden> buscarTodos() {
		return this.ordenRepository.findAll();
	}
}
