package pe.com.quecuadros.model;

import lombok.Data;

@Data
public class CuadroRequest {
	private String nombre;
	private int materialId;
	private int colorId;
	private String medidaHorizontal;
	private String medidaVertical;
	private byte[] imagen;
	//private Integer usuario;
}
