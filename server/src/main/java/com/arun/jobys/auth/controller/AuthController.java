package com.arun.jobys.auth.controller;

import com.arun.jobys.dto.LoginRequestDto;
import com.arun.jobys.dto.LoginResponseDto;
import com.arun.jobys.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final   AuthenticationManager authenticationManager;

    @PostMapping(value = "/login/public", version = "1.0")
    public ResponseEntity<LoginResponseDto> login(@RequestBody  LoginRequestDto loginRequestDto){

        try{
            var authenticatedResult = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDto.username(),
                            loginRequestDto.password()
                    )
            );

            var userDto = new UserDto();

            return ResponseEntity.status(HttpStatus.OK).body(
                            new LoginResponseDto(
                                    HttpStatus.OK.getReasonPhrase(),
                                    userDto, null
                            ));

        }catch (BadCredentialsException ex) {
            return buildErrorResponse(HttpStatus.UNAUTHORIZED,
                    "Invalid username or password");
        } catch (AuthenticationException ex) {
            return buildErrorResponse(HttpStatus.UNAUTHORIZED,
                    "Authentication failed");
        } catch (Exception ex) {
            return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    "An unexpected error occurred");
        }

    }

    private ResponseEntity<LoginResponseDto> buildErrorResponse(HttpStatus status, String message){
        return ResponseEntity.status(status).body(new LoginResponseDto(message, null, null));
    }
}
