package pe.com.quecuadros.model.request;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CuadroRequest {
	@NotBlank(message = "El nombre no puede estar en blanco")
	private String nombre;

	@NotBlank(message = "Debe escoger un material")
	private int materialId;

	@NotBlank(message = "Debe escoger un color")
	private int colorId;

	@NotBlank(message = "Debe ingresar la medida horizontal")
	private String medidaHorizontal;

	@NotBlank(message = "Debe ingresar la medida vertical")
	private String medidaVertical;

	@Nullable
	private byte[] imagen;

	private int usuarioId;
}
