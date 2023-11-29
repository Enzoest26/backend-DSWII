package pe.com.quecuadros.model.request;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdenCompraRequest {
	
	@NotNull(message = "El usuario no debe ser nulo")
	@Range(min = 1, message = "El identificador de usuario debe mayor de {min}")
	private Integer idUsuario;
	
	@NotNull(message = "El detalle de compra no debe ser nulo")
	@NotEmpty(message = "El detalle de compra no debe estar vacio")
	private List<DetalleCompraRequest> detalleCompra;
}
