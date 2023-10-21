package pe.com.quecuadros.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.util.ConstantesGenerales;

@RestController
public class GlobalRestController {

	@RequestMapping(method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT}, path = "/**")
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public BaseResponse error404() 
	{
		return BaseResponse.builder().codRespuesta(ConstantesGenerales.CODIGO_NO_EXISTE)
				.mensajeRespuesta(ConstantesGenerales.MENSAJE_NO_EXISTE)
				.build();
	}
}
