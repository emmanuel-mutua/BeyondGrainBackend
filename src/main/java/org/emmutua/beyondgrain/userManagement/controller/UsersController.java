package org.emmutua.beyondgrain.userManagement.controller;

import lombok.RequiredArgsConstructor;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.emmutua.beyondgrain.userManagement.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    private final AuthService authService;
    @GetMapping("/get_buyers")
    ResponseEntity<List<AppUser>> getBuyers(){
        var response = authService.getBuyers();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/get_sellers")
    ResponseEntity<List<AppUser>> getSellers(){
        var response = authService.getSellers();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/get_all_users")
    ResponseEntity<List<AppUser>> getAllUsers(){
        var response = authService.getAllUsers();
        return ResponseEntity.ok(response);
    }
}
