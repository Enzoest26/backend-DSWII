package pe.com.quecuadros.service;

import java.util.Optional;

import pe.com.quecuadros.model.Orden;
import pe.com.quecuadros.model.request.OrdenCompraRequest;

public interface ICarritoCompraService {
	
	public Optional<Orden> realizarVenta(OrdenCompraRequest ordenCompra);
}
