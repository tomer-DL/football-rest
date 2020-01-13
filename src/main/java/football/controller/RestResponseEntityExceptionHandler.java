package football.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import football.exception.ApiExceptionMessage;
import football.exception.ResourceNotFoundException;
import io.swagger.annotations.Api;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ResourceNotFoundException.class})
	public ResponseEntity<ApiExceptionMessage> handleNotFoundException(Exception ex, WebRequest request) {
		HttpStatus notFound = HttpStatus.NOT_FOUND;
		ApiExceptionMessage message = new ApiExceptionMessage(ex.getMessage(), notFound, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<ApiExceptionMessage>(message, notFound);
	}
}
