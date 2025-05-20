package com.runverve.runvervedemoproject.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String userMail;
    private String userPassword;
}
