package dev.naman.mc_ecomuserservice.controllers;

import dev.naman.mc_ecomuserservice.dtos.SignUpUserRequestDto;
import dev.naman.mc_ecomuserservice.dtos.VerifyUserRequestDto;
import dev.naman.mc_ecomuserservice.models.User;
import dev.naman.mc_ecomuserservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User signUp(@RequestBody SignUpUserRequestDto requestDto) {
        return userService.signUp(requestDto.getEmail(), requestDto.getPassword());
    }

    @PostMapping("/users/verify")
    public boolean verifyUser(@RequestBody VerifyUserRequestDto requestDto) {
        return userService.verifyUser(requestDto.getEmail(), requestDto.getPassword());
    }
}
