package org.emmutua.beyondgrain.exception;

import org.emmutua.beyondgrain.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Says when whenever there is an exception, please handle it
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(CustomException exception) {
        return new ResponseEntity<>(
                new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST
        );
    }
}
