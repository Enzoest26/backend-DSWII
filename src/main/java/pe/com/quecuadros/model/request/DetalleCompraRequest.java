package pe.com.quecuadros.model.request;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DetalleCompraRequest {
	
	@NotNull(message = "El identificador producto no debe ser nulo")
	@Range(min = 1, message = "El identificador producto debe mayor de {min}")
	private Integer idProducto;
	
	@NotNull(message = "La cantidad no debe ser nulo")
	@Range(min = 1, message = "La cantidad de usuario debe mayor de {min}")
	private Integer cantidad;
	
	@NotNull(message = "El precio no debe ser nulo")
	@Range(min = 0, message = "El precio no puede ser menor de {min}")
	private Double precio;
}
