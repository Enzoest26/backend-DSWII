package pe.com.quecuadros.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.Material;
import pe.com.quecuadros.service.IMaterialService;

@RestController
@RequestMapping("/materiales")
@AllArgsConstructor
@Tag(name = "Materiales Controller", description = "Controlador de Materiales")
public class MaterialRestController {
	
	private IMaterialService materialService;
	
	@GetMapping
	public List<Material> buscarTodos() {
		return materialService.buscarTodos();
	}
}
