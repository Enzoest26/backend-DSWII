package pe.com.quecuadros.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.Color;
import pe.com.quecuadros.service.IColorService;

@RestController
@AllArgsConstructor
@RequestMapping("/colores")
@Tag(name= "Colores Controller", description = "Controlador de Colores")
public class ColorRestController {

	private IColorService colorService;
	
	@GetMapping
	public List<Color> buscarTodos() {
		return colorService.buscarTodos();
	}
}
