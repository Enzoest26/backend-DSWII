package pe.com.quecuadros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.quecuadros.model.Material;
import pe.com.quecuadros.service.IMaterialService;

@RestController
@RequestMapping("/material")
public class MaterialRestController {
	
	@Autowired
	private IMaterialService materialService;
	
	@GetMapping("/listarTodos")
	public List<Material> buscarTodos() {
		return materialService.buscarTodos();
	}
}
