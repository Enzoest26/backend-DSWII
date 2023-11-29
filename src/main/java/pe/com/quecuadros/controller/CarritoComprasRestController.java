package pe.com.quecuadros.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.request.OrdenCompraRequest;
import pe.com.quecuadros.service.ICarritoCompraService;

@RequestMapping("/carritos")
@RestController
@AllArgsConstructor
@Tag(name = "Carrito Compras Controller", description = "Controlador de Carrito de Compras")
public class CarritoComprasRestController 
{
	private ICarritoCompraService carritoCompraService;
	
	@PostMapping
	public ResponseEntity<?> realizarCompra(@RequestBody @Valid OrdenCompraRequest ordenCompra)
	{
		return ResponseEntity.of(this.carritoCompraService.realizarVenta(ordenCompra));
	}
}
