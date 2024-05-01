package com.durgesh.onlydevs.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		List<String> errors = ex.getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.toList());
		// Return one error message at a time
		errors.stream().findFirst().ifPresent(firstError -> {
			result.put("message", firstError);
			result.put("statusCode", HttpStatus.BAD_REQUEST.value());
			result.put("timeStamp", LocalDateTime.now());
		});
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	
}
