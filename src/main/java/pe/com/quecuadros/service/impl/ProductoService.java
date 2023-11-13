package pe.com.quecuadros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.quecuadros.exception.ItemNoEncontradoException;
import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.Color;
import pe.com.quecuadros.model.CuadroRequest;
import pe.com.quecuadros.model.Producto;
import pe.com.quecuadros.repository.IProductoRepository;
import pe.com.quecuadros.service.IProductoService;
import pe.com.quecuadros.util.ConstantesGenerales;

@Service
public class ProductoService implements IProductoService{

	private @Autowired IProductoRepository productoRepository;
	
	@Override
	public List<Producto> buscarTodos() {
		return this.productoRepository.findAll();
	}

	@Override
	public Producto registrarProducto(Producto producto) {
		return this.productoRepository.save(producto);
	}

	@Override
	public BaseResponse actualizarProducto(Producto producto) {
		if(this.productoRepository.existsById(producto.getIdProducto()))
		{
			this.productoRepository.save(producto);
			return BaseResponse.builder().codRespuesta(ConstantesGenerales.CODIGO_EXITO)
					.mensajeRespuesta(ConstantesGenerales.MENSAJE_ACTUALIZACION_EXITO)
					.build();
		}
		throw new ItemNoEncontradoException(ConstantesGenerales.PRODUCTO_NO_ENCONTRADO);
	}

	@Override
	public BaseResponse eliminarProducto(Integer id) {
		if(this.productoRepository.existsById(id))
		{
			this.productoRepository.deleteById(id);
			return BaseResponse.builder().codRespuesta(ConstantesGenerales.CODIGO_EXITO)
					.mensajeRespuesta(ConstantesGenerales.MENSAJE_ELIMINACION_EXITO)
					.build();
		}
		throw new ItemNoEncontradoException(ConstantesGenerales.PRODUCTO_NO_ENCONTRADO);
	}

	@Override
	public Producto resgistrarCuadroPersonalizado(CuadroRequest cuadroRequest) {
		

		return null;
	}

}
