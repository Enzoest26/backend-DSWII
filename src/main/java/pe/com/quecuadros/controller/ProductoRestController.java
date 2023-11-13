package pe.com.quecuadros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.CuadroRequest;
import pe.com.quecuadros.model.Producto;
import pe.com.quecuadros.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

	private @Autowired IProductoService productoService;
	
	@GetMapping("/listarTodos")
	public List<Producto> buscarTodos()
	{
		return this.productoService.buscarTodos();
	}
	
	@PostMapping("/registrar")
	public Producto registrarProducto(@RequestBody Producto usuario)
	{
		return this.productoService.registrarProducto(usuario);
	}
	
	@PutMapping("/actualizar")
	public BaseResponse actualizarProducto(@RequestBody Producto usuario)
	{
		return this.productoService.actualizarProducto(usuario);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public BaseResponse actualizarProducto(@PathVariable Integer id)
	{
		return this.productoService.eliminarProducto(id);
	}
	
	@PostMapping("/personalizado")
	public Producto registrarCuadroPersonalizado(@RequestBody CuadroRequest producto) {
		return this.productoService.resgistrarCuadroPersonalizado(producto);
		
	}
}
