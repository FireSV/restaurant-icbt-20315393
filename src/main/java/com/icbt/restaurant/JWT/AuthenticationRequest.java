package com.icbt.restaurant.JWT;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;

}
