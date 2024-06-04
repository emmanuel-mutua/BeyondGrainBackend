package org.emmutua.beyondgrain.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SuccessResponse extends Response {
    private boolean success;
    private String message;
    private Object data;
    public SuccessResponse() {}
    public SuccessResponse(boolean success,String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public static <T> SuccessResponse success(String message, T data) {
        return new SuccessResponse(true, message, data);
    }
}
