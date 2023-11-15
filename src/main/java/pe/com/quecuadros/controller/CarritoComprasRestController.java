package pe.com.quecuadros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.OrdenCompraRequest;
import pe.com.quecuadros.service.ICarritoCompraService;

@RequestMapping("/carrito")
@RestController
public class CarritoComprasRestController 
{
	private @Autowired ICarritoCompraService carritoCompraService;
	
	@PostMapping("/venta")
	public BaseResponse realizarCompra(@RequestBody OrdenCompraRequest ordenCompra)
	{
		return this.carritoCompraService.realizarVenta(ordenCompra);
	}
}
