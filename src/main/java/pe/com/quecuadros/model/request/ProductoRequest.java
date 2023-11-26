package pe.com.quecuadros.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductoRequest {
	
	private Integer idProducto;
	
	@NotNull(message = "La cantidad no puede ser nula")
	@Min(value = 1, message = "La cantidad debe ser al menos 1")
	private Integer cantidad;
	
	@NotBlank(message = "La descripción no puede estar en blanco")
	private String descripcion;
	
	private byte[] imagen;
	
	@NotBlank(message = "El nombre no puede estar en blanco")
	private String nombre;
	
	@NotNull(message = "El precio no puede ser nulo")
    @Min(value = 0, message = "El precio no puede ser negativo")
	private Double precio;
	
	private Integer usuarioId;
	
	private Integer color;
	
	private Integer material;
}
