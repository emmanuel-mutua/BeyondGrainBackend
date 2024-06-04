package org.emmutua.beyondgrain.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private boolean success;
    private String message;
}

