package org.emmutua.beyondgrain.userManagement.controller;

import lombok.RequiredArgsConstructor;
import org.emmutua.beyondgrain.userManagement.dtos.LoginRequest;
import org.emmutua.beyondgrain.userManagement.dtos.LoginResponse;
import org.emmutua.beyondgrain.userManagement.dtos.RegisterRequest;
import org.emmutua.beyondgrain.userManagement.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;

    @PostMapping("/create_user")
    ResponseEntity<String> createNewUser(@RequestBody RegisterRequest registerRequest){
        var response = authService.createUser(registerRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login_user")
    ResponseEntity<LoginResponse> login_user(@RequestBody LoginRequest loginRequest){
        var response = authService.loginUser(loginRequest);
        return ResponseEntity.ok(response);
    }
}
