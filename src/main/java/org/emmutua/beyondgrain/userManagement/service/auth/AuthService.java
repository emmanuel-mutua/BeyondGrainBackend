package org.emmutua.beyondgrain.userManagement.service.auth;

import org.emmutua.beyondgrain.mapper.AppUserDto;
import org.emmutua.beyondgrain.response.Response;
import org.emmutua.beyondgrain.userManagement.dtos.LoginRequest;
import org.emmutua.beyondgrain.userManagement.dtos.RegisterRequest;
import org.emmutua.beyondgrain.userManagement.model.AppUser;

import java.util.List;

public interface AuthService {

    Response createUser(RegisterRequest registerRequest);

    Response loginUser(LoginRequest loginRequest);

    List<AppUserDto> getBuyers();
    List<AppUserDto> getSellers();

    List<AppUserDto> getAllUsers();
}
