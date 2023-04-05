package com.example.AppEcommerce.Impl;


import com.example.AppEcommerce.Dto.LoginRequest;
import com.example.AppEcommerce.Dto.SignUpAdmin;
import org.springframework.http.ResponseEntity;

public interface AuthServiceImp {
    ResponseEntity<?> registerAdmin(SignUpAdmin signUpAdmin);

    ResponseEntity<?> login(LoginRequest loginRequest);
}
