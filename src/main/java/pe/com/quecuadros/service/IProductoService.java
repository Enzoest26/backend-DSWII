package pe.com.quecuadros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import pe.com.quecuadros.model.Producto;
import pe.com.quecuadros.model.request.CuadroRequest;
import pe.com.quecuadros.model.request.ProductoRequest;

public interface IProductoService {
	
	public List<Producto> buscarTodos();
	
	public List<Producto> obtener3Ultimos();
	
	public Optional<Producto> buscarPorId(Integer id);
	
	public Page<Producto> buscarPorPaginado(Integer pagina);
	
	public Producto registrarProducto(ProductoRequest producto);
	
	public Optional<Producto> actualizarProducto(ProductoRequest producto);
	
	public void eliminarProducto(Integer id);
	
	public Producto resgistrarCuadroPersonalizado(CuadroRequest cuadroRequest);
	
}
