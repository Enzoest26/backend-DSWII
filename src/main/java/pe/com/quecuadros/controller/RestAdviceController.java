package pe.com.quecuadros.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.com.quecuadros.exception.ItemNoEncontradoException;
import pe.com.quecuadros.model.BaseResponse;
import pe.com.quecuadros.util.ConstantesGenerales;

@RestControllerAdvice
public class RestAdviceController 
{
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public BaseResponse errorException(Exception exception)
	{
		exception.printStackTrace();
		return BaseResponse.builder().codRespuesta(ConstantesGenerales.CODIGO_ERROR)
				.mensajeRespuesta(ConstantesGenerales.MENSAJE_INTERNO_ERROR)
				.descripcion(exception.getMessage())
				.build();
	}
	
	@ExceptionHandler(ItemNoEncontradoException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public BaseResponse errorItemNoEncontradoException(ItemNoEncontradoException exception)
	{
		return BaseResponse.builder()
				.codRespuesta(ConstantesGenerales.CODIGO_ERROR)
				.mensajeRespuesta(exception.getMessage())
				.build();
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public BaseResponse errorHttpMessageNotReadableException(HttpMessageNotReadableException exception)
	{
		return BaseResponse.builder()
				.codRespuesta(ConstantesGenerales.CODIGO_ERROR)
				.mensajeRespuesta(ConstantesGenerales.MENSAJE_ERROR_HTTP_NOT_READABLE)
				.descripcion(exception.getMessage())
				.build();
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public BaseResponse errorDataIntegrityViolationException(DataIntegrityViolationException exception)
	{
		return BaseResponse.builder()
				.codRespuesta(ConstantesGenerales.CODIGO_ERROR)
				.mensajeRespuesta(ConstantesGenerales.MENSAJE_ITEM_CONFLICTO)
				.descripcion(exception.getMessage())
				.build();
	}
	
}
