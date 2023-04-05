package com.example.AppEcommerce.Controller;

import com.example.AppEcommerce.Dto.LoginRequest;
import com.example.AppEcommerce.Dto.SignUpAdmin;
import com.example.AppEcommerce.Dto.SignUpUser;
import com.example.AppEcommerce.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")// tnajm t7el il port wala ta5u il permission mn springsecurity config

public class AuthController {
    @Autowired
    AuthService authService;


    @PostMapping("/registerAdmin")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignUpAdmin signUpAdmin){
        return authService.registerAdmin(signUpAdmin);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpUser signUpUser){
        return authService.registerUser(signUpUser);
    }



}
