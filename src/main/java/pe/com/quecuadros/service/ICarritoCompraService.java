package pe.com.quecuadros.service;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.model.OrdenCompraRequest;

public interface ICarritoCompraService {
	
	public BaseResponse realizarVenta(OrdenCompraRequest ordenCompra);
}
