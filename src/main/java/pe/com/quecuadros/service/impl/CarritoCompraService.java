package pe.com.quecuadros.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.DetalleCompraRequest;
import pe.com.quecuadros.model.DetalleOrden;
import pe.com.quecuadros.model.Orden;
import pe.com.quecuadros.model.OrdenCompraRequest;
import pe.com.quecuadros.model.Producto;
import pe.com.quecuadros.repository.IDetalleOrdenRepository;
import pe.com.quecuadros.repository.IOrdenRepository;
import pe.com.quecuadros.service.ICarritoCompraService;
import pe.com.quecuadros.service.IProductoService;
import pe.com.quecuadros.service.IUsuarioService;
import pe.com.quecuadros.util.ConstantesGenerales;

@Service
public class CarritoCompraService implements ICarritoCompraService
{
	private @Autowired IOrdenRepository ordenRepository;
	private @Autowired IDetalleOrdenRepository detalleOrdenRepository;
	private @Autowired IUsuarioService usuarioService;
	private @Autowired IProductoService productoService;
	
	@Override
	@Transactional
	public BaseResponse realizarVenta(OrdenCompraRequest ordenCompra)
	{
		List<DetalleOrden> detalles = new ArrayList<>();
		double total = 0.0;
		for (DetalleCompraRequest s : ordenCompra.getDetalleCompra()) 
		{
			DetalleOrden detalleOrden = new DetalleOrden();
			detalleOrden.setCantidad(s.getCantidad());
			detalleOrden.setPrecio(s.getPrecio());
			Producto producto = this.productoService.buscarPorId(s.getIdProducto());
			detalleOrden.setProducto(producto);
			detalleOrden.setTotal(s.getPrecio() * s.getCantidad());
			detalleOrden.setNombre(producto.getNombre());
			detalles.add(detalleOrden);
			total += detalleOrden.getTotal();
		}
		List<Orden> obtenerUltimo = this.ordenRepository.findTopByOrderByIdDesc();
		Orden orden = new Orden();
		orden.setFechaCreacion(LocalDateTime.now());
		String numeroConCeros = String.format("%010d", obtenerUltimo.get(0).getId() + 1);
		orden.setDetalles(detalles);
		orden.setNumero(numeroConCeros);
		orden.setTotal(total);
		orden.setUsuario(this.usuarioService.buscarPorId(ordenCompra.getIdUsuario()));
		this.ordenRepository.save(orden);
		detalles.stream().forEach(s ->{ 
			List<Orden> ultimo = this.ordenRepository.findTopByOrderByIdDesc();
			s.setIdOrden(ultimo.get(0).getId());
		});
		this.detalleOrdenRepository.saveAll(detalles);
		return BaseResponse.builder()
				.codRespuesta(ConstantesGenerales.CODIGO_EXITO)
				.mensajeRespuesta(ConstantesGenerales.MENSAJE_VENTA_EXITO)
				.build();
	}

}
