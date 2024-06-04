package org.emmutua.beyondgrain.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    private boolean success;
    private String message;
    public ErrorResponse() {}
    public ErrorResponse(String message) {
        this.message = message;
        this.success = false;
    }
    public static  ErrorResponse error(String message) {
        return new ErrorResponse(message);
    }
}
