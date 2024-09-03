package com.icbt.restaurant.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1")
public class AuthenticationController {

    @Autowired
    private
    AuthenticationManager authenticationManager;

    @Autowired
    private
    JwtUtil jwtUtil;

    @Autowired
    private
    UserDetailsService userDetailsService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        Optional<User> userOptional = userRepository.findByUsername(authenticationRequest.getUsername());
        userOptional.get().setToken(jwt);
        userOptional.get().setPassword(null);
        return ResponseEntity.ok(userOptional);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthenticationRequest request) {
        if (customUserDetailsService.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }
        Optional<Role> roleOptional = roleRepo.findByName(request.getRole());
        if (roleOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found !");
        }




        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        Set<Role> roles = new HashSet<>();
        roles.add(roleOptional.get());
        newUser.setRoles(roles);

        User userSaved = customUserDetailsService.registerUser(newUser);


        return ResponseEntity.ok("User registered successfully");
    }
}

