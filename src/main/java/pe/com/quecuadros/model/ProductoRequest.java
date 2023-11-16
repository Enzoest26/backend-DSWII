package pe.com.quecuadros.model;

import lombok.Data;

@Data
public class ProductoRequest {
	
	private Integer idProducto;
	private Integer cantidad;
	
	private String descripcion;
	
	private byte[] imagen;
	
	private String nombre;
	
	private Double precio;
	
	private Integer usuarioId;
	
	private Integer color;
	
	private Integer material;
}
