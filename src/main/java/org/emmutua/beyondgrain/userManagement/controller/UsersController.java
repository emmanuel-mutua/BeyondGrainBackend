package org.emmutua.beyondgrain.userManagement.controller;

import lombok.RequiredArgsConstructor;
import org.emmutua.beyondgrain.mapper.AppUserDto;
import org.emmutua.beyondgrain.userManagement.service.auth.AuthService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    private final AuthService authService;
    @GetMapping("/get_buyers")
    ResponseEntity<List<AppUserDto>> getBuyers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Pageable paging = PageRequest.of(page, size);
        var response = authService.getBuyers(paging);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/get_sellers")
    ResponseEntity<List<AppUserDto>> getSellers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Pageable paging = PageRequest.of(page, size);
        var response = authService.getSellers(paging);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/get_all_users")
    ResponseEntity<List<AppUserDto>> getAllUsers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Pageable paging = PageRequest.of(page, size);
        var response = authService.getAllUsers(paging);
        return ResponseEntity.ok(response);
    }
}
