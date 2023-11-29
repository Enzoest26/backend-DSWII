package pe.com.quecuadros.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pe.com.quecuadros.model.DetalleOrden;
import pe.com.quecuadros.model.Orden;
import pe.com.quecuadros.model.Producto;
import pe.com.quecuadros.model.request.DetalleCompraRequest;
import pe.com.quecuadros.model.request.OrdenCompraRequest;
import pe.com.quecuadros.repository.IDetalleOrdenRepository;
import pe.com.quecuadros.repository.IOrdenRepository;
import pe.com.quecuadros.service.ICarritoCompraService;
import pe.com.quecuadros.service.IProductoService;
import pe.com.quecuadros.service.IUsuarioService;

@Service
@AllArgsConstructor
public class CarritoCompraService implements ICarritoCompraService
{
	private IOrdenRepository ordenRepository;
	private IDetalleOrdenRepository detalleOrdenRepository;
	private IUsuarioService usuarioService;
	private IProductoService productoService;
	
	@Override
	@Transactional
	public Optional<Orden> realizarVenta(OrdenCompraRequest ordenCompra)
	{
		List<DetalleOrden> detalles = new ArrayList<>();
		double total = 0.0;
		for (DetalleCompraRequest s : ordenCompra.getDetalleCompra()) 
		{
			DetalleOrden detalleOrden = new DetalleOrden();
			detalleOrden.setCantidad(s.getCantidad());
			detalleOrden.setPrecio(s.getPrecio());
			//
			Producto producto = this.productoService.buscarPorId(s.getIdProducto()).orElse(null);
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
		orden.setUsuario(this.usuarioService.buscarPorId(ordenCompra.getIdUsuario()).get());
		Orden orden2 = this.ordenRepository.save(orden);
		detalles.stream().forEach(s ->{ 
			List<Orden> ultimo = this.ordenRepository.findTopByOrderByIdDesc();
			s.setIdOrden(ultimo.get(0).getId());
		});
		this.detalleOrdenRepository.saveAll(detalles);
		return this.ordenRepository.findById(orden.getId());
	}

}
