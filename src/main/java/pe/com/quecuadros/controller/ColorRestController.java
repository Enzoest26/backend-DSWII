package pe.com.quecuadros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.quecuadros.model.Color;
import pe.com.quecuadros.service.IColorService;

@RestController
@RequestMapping("/color")
public class ColorRestController {

	@Autowired
	private IColorService colorService;
	
	@GetMapping("/listarTodos")
	public List<Color> buscarTodos() {
		return colorService.buscarTodos();
	}
}
