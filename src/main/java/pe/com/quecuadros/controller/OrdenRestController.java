package pe.com.quecuadros.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.Orden;
import pe.com.quecuadros.service.IOrdenService;

@RestController
@AllArgsConstructor
@RequestMapping("/reportes")
@Tag(name = "Ordenes controller", description = "Controlador de ordenes")
public class OrdenRestController {

	private IOrdenService ordenService;
	
	@GetMapping
	public List<Orden> buscarTodos() {
		return this.ordenService.buscarTodos();
	}
}
