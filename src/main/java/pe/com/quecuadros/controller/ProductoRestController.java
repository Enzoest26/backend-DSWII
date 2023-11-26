package pe.com.quecuadros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.CuadroRequest;
import pe.com.quecuadros.model.Producto;
import pe.com.quecuadros.model.ProductoRequest;
import pe.com.quecuadros.service.IProductoService;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoRestController {

	private IProductoService productoService;
	
	@GetMapping
	public ResponseEntity<?> buscarProductos()
	{
		return new ResponseEntity<>(this.productoService.buscarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.of(this.productoService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> registrarProducto(@RequestBody ProductoRequest request)
	{
		return new ResponseEntity<>(this.productoService.registrarProducto(request), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> actualizarProducto(@RequestBody ProductoRequest request)
	{
		return ResponseEntity.of(this.productoService.actualizarProducto(request));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void actualizarProducto(@PathVariable Integer id)
	{
		this.productoService.eliminarProducto(id);
	}
	
	@PostMapping("/personalizado")
	public Producto registrarCuadroPersonalizado(@RequestBody CuadroRequest producto) {
		return this.productoService.resgistrarCuadroPersonalizado(producto);		
	}

	@PutMapping("/personalizado/{id}")
	public Producto actualizarCuadroPersonalizado(@PathVariable Integer id, @RequestBody CuadroRequest cuadroRequest) {
		return this.productoService.actualizarCuadroPersonalizado(id, cuadroRequest);
	}
	
	@GetMapping("/buscarPorPagina")
	public Page<Producto> buscarPorPagina(@RequestParam Integer pagina)
	{
		return this.productoService.buscarPorPaginado(pagina);
	}
	
	@GetMapping("/primeros-3")
	public List<Producto> obtenerPrimeros3()
	{
		return this.productoService.obtener3Ultimos();
	}
	
}
