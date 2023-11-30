package pe.com.quecuadros.controller;

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
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.request.CuadroRequest;
import pe.com.quecuadros.model.request.ProductoRequest;
import pe.com.quecuadros.service.IColorService;
import pe.com.quecuadros.service.IMaterialService;
import pe.com.quecuadros.service.IProductoService;
import pe.com.quecuadros.service.IUsuarioService;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
@Tag(name= "Productos Controller", description = "Controlador de Productos")
public class ProductoRestController {

	private IProductoService productoService;
	private IColorService colorService;
	private IMaterialService materialService;
	private IUsuarioService usuarioService;
	
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
	public ResponseEntity<?> eliminarProducto(@PathVariable Integer id)
	{
		if(buscarPorId(id).getStatusCode() == HttpStatus.NOT_FOUND){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.productoService.eliminarProducto(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/personalizado")
	public ResponseEntity<?>  registrarCuadroPersonalizado(@RequestBody @Valid CuadroRequest producto) {
		if(colorService.buscarPorId(producto.getColorId()).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(materialService.buscarPorId(producto.getMaterialId()).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(usuarioService.buscarPorId(producto.getUsuarioId()).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(this.productoService.resgistrarCuadroPersonalizado(producto), HttpStatus.CREATED);		
	}
	
	@GetMapping("/paginas")
	public ResponseEntity<?> buscarPorPagina(@RequestParam Integer pagina)
	{
		if(pagina <= 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(this.productoService.buscarPorPaginado(pagina), HttpStatus.OK);
	}
	
	@GetMapping("/top-3")
	public ResponseEntity<?> obtenerPrimeros3()
	{
		return new ResponseEntity<>(this.productoService.obtener3Ultimos(), HttpStatus.OK);
	}
	
}
