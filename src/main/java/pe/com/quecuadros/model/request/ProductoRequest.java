package pe.com.quecuadros.model.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductoRequest {
	
	@Range(min = 0, message = "El id debe ser mayor a {min}")
	private Integer idProducto;
	
	@NotBlank(message = "La cantidad no debe estar en blanco")
	@NotNull(message = "Ingrese una cantidad")
	@Min(value = 1, message = "La cantidad debe ser al menos 1")
	private Integer cantidad;
	
	@NotNull(message = "Ingrese una descripcion")
	@NotBlank(message = "La descripción no puede estar en blanco")
	@Length(max = 255, message ="La descripción no debe superar los {max} caracteres")
	private String descripcion;
	
	private byte[] imagen;
	
	@NotNull(message = "Ingrese un nombre")
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Length(max = 255, message ="El nombre no debe superar los {max} caracteres")
	private String nombre;
	
	@NotBlank(message = "Ingrese un precio")
	@NotNull(message = "El precio no puede ser nulo")
    @Min(value = 0, message = "El precio no puede ser negativo")
	private Double precio;
	
	private Integer usuarioId;
	
	private Integer color;
	
	private Integer material;
}
