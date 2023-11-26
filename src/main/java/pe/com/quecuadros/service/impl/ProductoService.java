package pe.com.quecuadros.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import pe.com.quecuadros.exception.ItemNoEncontradoException;
import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.Color;
import pe.com.quecuadros.model.CuadroRequest;
import pe.com.quecuadros.model.Material;
import pe.com.quecuadros.model.Producto;
import pe.com.quecuadros.model.ProductoRequest;
import pe.com.quecuadros.repository.IColorRepository;
import pe.com.quecuadros.repository.IMaterialRepository;
import pe.com.quecuadros.repository.IProductoRepository;
import pe.com.quecuadros.service.IProductoService;
import pe.com.quecuadros.util.ConstantesGenerales;

@Service
public class ProductoService implements IProductoService{

	private IProductoRepository productoRepository;
	private IColorRepository colorRepository;
	private IMaterialRepository materialRepository;
	
	@Override
	public List<Producto> buscarTodos() {
		return this.productoRepository.findAll();
	}

	@Override
	public Producto registrarProducto(ProductoRequest productoRequest) {
		
		Producto producto = new Producto();
		producto.setCantidad(productoRequest.getCantidad());
		producto.setDescripcion(productoRequest.getDescripcion());
		producto.setImagen(productoRequest.getImagen());
		producto.setNombre(productoRequest.getNombre());
		producto.setPrecio(productoRequest.getPrecio());
		producto.setUsuarioId(productoRequest.getUsuarioId());
		Color color = this.colorRepository.findById(productoRequest.getColor()).orElseThrow(() -> new ItemNoEncontradoException("Color no encontrado"));
		Material material = this.materialRepository.findById(productoRequest.getMaterial()).orElseThrow(() -> new ItemNoEncontradoException("Material no encontrado"));
		producto.setMaterial(material);
		producto.setColor(color);
		return this.productoRepository.save(producto);
	}


	@Override
	public Producto resgistrarCuadroPersonalizado(CuadroRequest cuadroRequest) {
		Color color = colorRepository.findById(cuadroRequest.getColorId()).orElseThrow(() -> new ItemNoEncontradoException("Color no encontrado"));
		Material material = materialRepository.findById(cuadroRequest.getMaterialId()).orElseThrow(() -> new ItemNoEncontradoException("Material no encontrado"));
		
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
		producto.setDescripcion("Marco de " + material.getDescripcion() + ", color " + color.getDescripcion() + ", " + 
				cuadroRequest.getMedidaHorizontal() + " horizontal x " + cuadroRequest.getMedidaVertical() + " vertical");
		producto.setImagen(cuadroRequest.getImagen());
		producto.setUsuarioId(cuadroRequest.getUsuarioId());
		producto.setPrecio(40.0);
		producto.setCantidad(1);
		
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> buscarPorId(Integer id) {
		return this.productoRepository.findById(id);
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
		producto.setDescripcion("Marco de " + material.getDescripcion() + ", color " + color.getDescripcion() + ", " + 
				cuadroRequest.getMedidaHorizontal() + " horizontal x " + cuadroRequest.getMedidaVertical() + " vertical");
		producto.setImagen(cuadroRequest.getImagen());
		producto.setUsuarioId(cuadroRequest.getUsuarioId());
		producto.setPrecio(40.0);
		producto.setCantidad(1);
		
		return productoRepository.save(producto);
	}

	@Override
	public Page<Producto> buscarPorPaginado(Integer pagina) {
		Pageable paginado = PageRequest.of(pagina - 1, 10);
		return this.productoRepository.findAll(paginado);
	}

	@Override
	public List<Producto> obtener3Ultimos() {
		return this.productoRepository.findFirst3ByOrderByIdProductoDesc();
	}

	@Override
	public Optional<Producto> actualizarProducto(ProductoRequest request) {
		return this.productoRepository.findById(request.getIdProducto()).map(producto -> {
			producto.setCantidad(request.getCantidad());
			producto.setDescripcion(request.getDescripcion());
			producto.setImagen(request.getImagen());
			producto.setNombre(request.getNombre());
			producto.setPrecio(request.getPrecio());
			producto.setUsuarioId(request.getUsuarioId());
			Color color = this.colorRepository.findById(request.getColor()).orElseThrow(() -> new ItemNoEncontradoException("Color no encontrado"));
			Material material = this.materialRepository.findById(request.getMaterial()).orElseThrow(() -> new ItemNoEncontradoException("Material no encontrado"));
			producto.setMaterial(material);
			producto.setColor(color);
			return this.productoRepository.save(producto);
		});
	}

	@Override
	public void eliminarProducto(Integer id) {
		this.productoRepository.deleteById(id);
	}

}
