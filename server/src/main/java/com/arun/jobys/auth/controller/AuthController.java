package com.arun.jobys.auth.controller;

import com.arun.jobys.dto.LoginRequestDto;
import com.arun.jobys.dto.LoginResponseDto;
import com.arun.jobys.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/login/public")
    public ResponseEntity<LoginResponseDto> login(@RequestBody  LoginRequestDto loginRequestDto){
        var userDto = new UserDto();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new LoginResponseDto(
                                HttpStatus.OK.getReasonPhrase(),
                                userDto, null)
                );
    }
}
