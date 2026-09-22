package br.com.gos.devshowcase.Gestao_Notas2.exception;

import java.time.Instant;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice 
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object> > handleNotFound(ResourceNotFoundExeption ex, HttpServletRequest)
		Map<String, Object> err = new HashMap<>();
		err.put("timestamp",Instant.now());
		err.put("status", HttpStatus.NOT_FOUND.value());
		err.put("error","Recurso não encontrado ");
		err.put("message",ex.getMessage());
		err.put("path",req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	

	}

	@ExceptionHandler(BusnessException.class)
	public ResponseEntity<Map<String, Object>> handlerBusness(BusnessException ex,HttpServletRequest req) {
		Map<String, Object> err = new HashMap<>();
		err.put("timestamp",Instant.now());
		err.put("status", HttpStatus.BAD_REQUEST.value());
		err.put("error","Regra de negócio violada ");
		err.put("message",ex.getMessage());
		err.put("path",req.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST) .body(err);
	}
		
	@ExceptionHandler(MethodArgumentNotValidEexception.class)
	public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex,HttpServletRequest req){
		Map<String, Object> err = new HashMap<>();
		Map<String, String> fieldErrors = HashMap<>();
		for (FieldError f : ex.getBindingResult().getFieldErrors()) {
			fieldErrors.put(f.getField(),f.getDefaultMessage());
		}
		err.put("timestamp", Instant.now());
		err.put("status",HttpStatus.BAD_REQUEST);
		err.put("error","Erro de validação");
		err.put("fields",fieldErrors);
		err.put("path",req.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	
	}
	
}
