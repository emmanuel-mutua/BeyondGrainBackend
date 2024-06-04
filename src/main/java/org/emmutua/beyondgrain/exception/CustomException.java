package org.emmutua.beyondgrain.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
