package com.icbt.restaurant.JWT;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String address;
    private String mobile;
    private String role;

}
