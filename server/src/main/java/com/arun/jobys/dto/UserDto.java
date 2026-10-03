package com.arun.jobys.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter @Setter
@ToString
public class UserDto {
    private long userId;
    private String name;
    private String email;
    private String mobileNumber;
    private String role;
    private String companyId;
    private String companyName;
    private Instant createdAt;
}
