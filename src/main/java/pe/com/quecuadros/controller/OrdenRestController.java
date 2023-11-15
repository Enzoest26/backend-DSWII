package pe.com.quecuadros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.quecuadros.model.Orden;
import pe.com.quecuadros.service.IOrdenService;

@RestController
@RequestMapping("/reporte")
public class OrdenRestController {

	private @Autowired IOrdenService ordenService;
	
	@GetMapping
	public List<Orden> buscarTodos()
	{
		return this.ordenService.buscarTodos();
	}
}
