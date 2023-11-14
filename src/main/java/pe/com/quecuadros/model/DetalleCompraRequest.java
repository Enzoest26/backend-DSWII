package pe.com.quecuadros.model;

import lombok.Data;

@Data
public class DetalleCompraRequest {
	
	private Integer id;
	
	private Integer cantidad;
	
	private Double precio;
}
