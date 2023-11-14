package pe.com.quecuadros.model;

import java.util.List;

import lombok.Data;

@Data
public class OrdenCompraRequest {
	
	private String idUsuario;
	
	private List<DetalleCompraRequest> detalleCompra;
}
