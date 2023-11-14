package pe.com.quecuadros.service;

import java.util.List;

import org.springframework.data.domain.Page;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.CuadroRequest;
import pe.com.quecuadros.model.Producto;
import pe.com.quecuadros.model.Usuario;

public interface IProductoService {
	
	public List<Producto> buscarTodos();
	
	public Producto buscarPorId(Integer id);
	
	public Page<Producto> buscarPorPaginado(Integer pagina);
	
	public Producto registrarProducto(Producto producto);
	
	public BaseResponse actualizarProducto(Producto producto);
	
	public BaseResponse eliminarProducto(Integer id);
	
	public Producto resgistrarCuadroPersonalizado(CuadroRequest cuadroRequest);
	
	public Producto actualizarCuadroPersonalizado(Integer id, CuadroRequest cuadroRequest);
}
