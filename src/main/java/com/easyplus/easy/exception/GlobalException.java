package com.easyplus.easy.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> globalException(Exception e){
		Map<String , Object> map = new HashMap<>();
		map.put("mensaje", e.getMessage());
		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> noFoundException(NoSuchElementException e){
		Map<String , Object> map = new HashMap<>();
		map.put("mensaje", "Usuario no encontrado");
		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
	}
	
	//Manejador de excepcion de argumentos de clase incompletos 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> argumentNoValid(MethodArgumentNotValidException e){
		Map<String , Object> map = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMensaje = error.getDefaultMessage();
			map.put(fieldName, errorMensaje);
		});
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	//Manejador de excepcion de usuario duplicado
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> userDuplicate (DataIntegrityViolationException e){
		Map<String , Object> map = new HashMap<>();
		map.put("mensaje", e.getMessage());
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	//Manejador de excepcion de campos de usuario invalidos
		@ExceptionHandler(IllegalArgumentException.class)
		public ResponseEntity<Object> camposUsuarioInvalidos (IllegalArgumentException e){
			Map<String , Object> map = new HashMap<>();
			map.put("mensaje", "Campos invalidos");
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
}
