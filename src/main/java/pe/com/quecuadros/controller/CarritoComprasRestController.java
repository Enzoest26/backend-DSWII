package pe.com.quecuadros.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.OrdenCompraRequest;

@RequestMapping("/carrito")
@RestController
public class CarritoComprasRestController 
{
	@PostMapping("/venta")
	public BaseResponse realizarCompra(@RequestBody OrdenCompraRequest ordenCompra)
	{
		return null;
	}
}
