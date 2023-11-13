package pe.com.quecuadros.model;

import lombok.Data;

@Data
public class CuadroRequest {
	private String nombre;
	private int materialId;
	private int colorId;
	private String descripcion;
	private byte[] imagen;
	//private Integer usuario;
}
