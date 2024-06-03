package org.emmutua.beyondgrain.userManagement.service.auth;

import lombok.RequiredArgsConstructor;
import org.emmutua.beyondgrain.config.jwt.JwtService;
import org.emmutua.beyondgrain.userManagement.dtos.LoginRequest;
import org.emmutua.beyondgrain.userManagement.dtos.LoginResponse;
import org.emmutua.beyondgrain.userManagement.dtos.RegisterRequest;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.emmutua.beyondgrain.userManagement.model.UserType;
import org.emmutua.beyondgrain.userManagement.repositories.UserRepository;
import org.emmutua.beyondgrain.userManagement.token.Token;
import org.emmutua.beyondgrain.userManagement.token.TokenRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String createUser(RegisterRequest registerRequest) {
        try {
            UserType userType;
            if (registerRequest.getRole().equals(UserType.BUYER.name())) {
                userType = UserType.BUYER;
            } else if (registerRequest.getRole().equals(UserType.SELLER.name())) {
                userType = UserType.SELLER;
            } else {
                throw new RuntimeException("Invalid role");
            }

            AppUser appUser = AppUser.builder()
                    .fullName(registerRequest.getFullname())
                    .email(registerRequest.getEmail())
                    .password(passwordEncoder.encode(registerRequest.getPassword()))
                    .phone(registerRequest.getPhoneNumber())
                    .idNo(registerRequest.getIdNumber())
                    .role(userType)
                    .build();
            userRepository.save(appUser);
            return "User created";
        } catch (Exception e) {
            throw new RuntimeException("Failed to save user");
        }
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
            var loggedInUser = userRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
            var jwtToken = jwtService.generateToken(loggedInUser);
            Token token = Token.builder()
                    .appUser(loggedInUser)
                    .token(jwtToken)
                    .expired(false)
                    .revoked(false)
                    .build();
            tokenRepository.save(token);

            return LoginResponse.builder()
                    .token(jwtToken)
                    .userRole(loggedInUser.getRole().name())
                    .build();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to login user");
        }
    }
}
