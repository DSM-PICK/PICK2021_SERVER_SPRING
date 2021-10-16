package io.github.pickdsm.pick_server_spring.global.error;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PickException.class)
	protected ResponseEntity<ErrorResponse> pickExceptionHandler(PickException e) {
		ErrorCode code = e.getErrorCode();
		return new ResponseEntity<>(new ErrorResponse(code.getStatus(),
				code.getCode(), code.getMessage()), HttpStatus.valueOf(code.getStatus()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorResponse> validatorExceptionHandler(MethodArgumentNotValidException e) {
		return new ResponseEntity<>(new ErrorResponse(400, "APPLICATION-400-0",
				e.getBindingResult().getAllErrors().get(0).getDefaultMessage()),
				HttpStatus.BAD_REQUEST);
	}

}
