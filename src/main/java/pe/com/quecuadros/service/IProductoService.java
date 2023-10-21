package pe.com.quecuadros.service;

import java.util.List;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.Producto;

public interface IProductoService {
	
	public List<Producto> buscarTodos();
	
	public Producto registrarProducto(Producto producto);
	
	public BaseResponse actualizarProducto(Producto producto);
	
	public BaseResponse eliminarProducto(Integer id);
}
