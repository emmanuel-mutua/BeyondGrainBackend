package org.emmutua.beyondgrain.userManagement.service.auth;

import org.emmutua.beyondgrain.userManagement.dtos.LoginRequest;
import org.emmutua.beyondgrain.userManagement.dtos.LoginResponse;
import org.emmutua.beyondgrain.userManagement.dtos.RegisterRequest;

public interface AuthService {

    String createUser(RegisterRequest registerRequest);

    LoginResponse loginUser(LoginRequest loginRequest);
}
