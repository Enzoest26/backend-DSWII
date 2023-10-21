package pe.com.quecuadros.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse {
	
	public String codRespuesta;
	
	public String mensajeRespuesta;
	
	@JsonInclude(value = Include.NON_NULL)
	public String descripcion;
}
