package org.emmutua.beyondgrain.userManagement.service.auth;

import org.emmutua.beyondgrain.mapper.AppUserDto;
import org.emmutua.beyondgrain.response.Response;
import org.emmutua.beyondgrain.userManagement.dtos.LoginRequest;
import org.emmutua.beyondgrain.userManagement.dtos.RegisterRequest;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthService {

    Response createUser(RegisterRequest registerRequest);

    Response loginUser(LoginRequest loginRequest);

    List<AppUserDto> getBuyers(Pageable pageable);
    List<AppUserDto> getSellers(Pageable pageable);

    List<AppUserDto> getAllUsers(Pageable pageable);
}
