package com.arun.jobys.dto;

public record LoginResponseDto(String message, UserDto userDto, String jwtToken) {
}
