package pe.com.quecuadros.model.request;

import org.hibernate.validator.constraints.Length;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CuadroRequest {
	@NotNull(message = "Ingrese una cantidad")
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Length(max = 255, message ="El nombre no debe superar los {max} caracteres")
	private String nombre;

	@NotNull(message = "Ingrese un material")
	private Integer materialId;

	@NotNull(message = "Ingrese un color")
	private Integer colorId;

	@NotNull(message = "Ingrese una medida horizontal")
	@NotBlank(message = "La medida horizontal no puede estar en blanco")
	private String medidaHorizontal;

	@NotNull(message = "Ingrese una medida vertical")
	@NotBlank(message = "La medida vertical no puede estar en blanco")
	private String medidaVertical;

	@Nullable
	private byte[] imagen;

	@NotNull(message = "Ingrese un id de usuario")
	private Integer usuarioId;
}
