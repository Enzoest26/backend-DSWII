package pe.com.quecuadros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.quecuadros.exception.ItemNoEncontradoException;
import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.Color;
import pe.com.quecuadros.model.CuadroRequest;
import pe.com.quecuadros.model.Material;
import pe.com.quecuadros.model.Producto;
import pe.com.quecuadros.repository.IColorRepository;
import pe.com.quecuadros.repository.IMaterialRepository;
import pe.com.quecuadros.repository.IProductoRepository;
import pe.com.quecuadros.service.IProductoService;
import pe.com.quecuadros.util.ConstantesGenerales;

@Service
public class ProductoService implements IProductoService{

	private @Autowired IProductoRepository productoRepository;
	private @Autowired IColorRepository colorRepository;
	private @Autowired IMaterialRepository materialRepository;
	
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
		Color color = colorRepository.findById(cuadroRequest.getColorId()).orElse(null);
		Material material = materialRepository.findById(cuadroRequest.getMaterialId()).orElse(null);
		
		if(color == null) {
			throw new ItemNoEncontradoException(ConstantesGenerales.COLOR_NO_ENCONTRADO);
		}
		if(material == null) {
			throw new ItemNoEncontradoException(ConstantesGenerales.MATERIAL_NO_ENCONTRADO);
		}
		
		Producto producto = new Producto();
		producto.setNombre("Cuadro Personalizado - " + cuadroRequest.getNombre());
		producto.setColor(color);
		producto.setMaterial(material);
		producto.setDescripcion(cuadroRequest.getMedidaHorizontal() + " horizontal x " + cuadroRequest.getMedidaVertical() + " vertical");
		producto.setImagen(cuadroRequest.getImagen());
		producto.setPrecio(40.0);
		producto.setCantidad(1);
		
		return productoRepository.save(producto);
	}

	@Override
	public Producto buscarPorId(Integer id) {
		Producto producto = productoRepository.findById(id).orElse(null);
		
		if(producto != null) {
			return producto;
		}
		
		throw new ItemNoEncontradoException(ConstantesGenerales.PRODUCTO_NO_ENCONTRADO);
	}

	@Override
	public Producto actualizarCuadroPersonalizado(Integer id, CuadroRequest cuadroRequest) {
		Producto producto = productoRepository.findById(id).orElse(null);
		Color color = colorRepository.findById(cuadroRequest.getColorId()).orElse(null);
		Material material = materialRepository.findById(cuadroRequest.getMaterialId()).orElse(null);
		
		if(color == null) {
			throw new ItemNoEncontradoException(ConstantesGenerales.COLOR_NO_ENCONTRADO);
		}
		if(material == null) {
			throw new ItemNoEncontradoException(ConstantesGenerales.MATERIAL_NO_ENCONTRADO);
		}
		if(producto == null) {
			throw new ItemNoEncontradoException(ConstantesGenerales.PRODUCTO_NO_ENCONTRADO);
		}
		
		producto.setNombre("Cuadro Personalizado - " + cuadroRequest.getNombre());
		producto.setColor(color);
		producto.setMaterial(material);
		producto.setDescripcion(cuadroRequest.getMedidaHorizontal() + " horizontal x " + cuadroRequest.getMedidaVertical() + " vertical");
		producto.setImagen(cuadroRequest.getImagen());
		producto.setPrecio(40.0);
		producto.setCantidad(1);
		
		return productoRepository.save(producto);
	}

}
