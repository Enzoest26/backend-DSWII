package pe.com.quecuadros.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdviceController 
{
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> errorMethodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		Map<String, Object> response = new HashMap<>();
		List<String> listErrores = exception.getAllErrors().stream()
			    .map(DefaultMessageSourceResolvable::getDefaultMessage)
			    .collect(Collectors.toList());
		response.put("errores", listErrores);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
