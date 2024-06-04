package org.emmutua.beyondgrain.userManagement.service.auth;

import org.emmutua.beyondgrain.response.Response;
import org.emmutua.beyondgrain.userManagement.dtos.LoginRequest;
import org.emmutua.beyondgrain.userManagement.dtos.RegisterRequest;

public interface AuthService {

    Response createUser(RegisterRequest registerRequest);

    Response loginUser(LoginRequest loginRequest);
}
