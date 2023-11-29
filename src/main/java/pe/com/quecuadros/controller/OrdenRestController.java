package pe.com.quecuadros.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import pe.com.quecuadros.service.IOrdenService;

@RestController
@AllArgsConstructor
@RequestMapping("/reportes")
@Tag(name = "Ordenes controller", description = "Controlador de ordenes")
public class OrdenRestController {

	private IOrdenService ordenService;
	
	@GetMapping
	public ResponseEntity<?> buscarTodos() {
		return new ResponseEntity<>(this.ordenService.buscarTodos(), HttpStatus.OK);
	}
}
