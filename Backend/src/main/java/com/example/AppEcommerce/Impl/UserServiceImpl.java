package com.example.AppEcommerce.Impl;

import com.example.AppEcommerce.Dto.SignUpAdmin;
import com.example.AppEcommerce.Dto.SignUpUser;
import org.springframework.http.ResponseEntity;

public interface UserServiceImpl {
    ResponseEntity<?> registerAdmin(SignUpAdmin signUpAdmin);

    ResponseEntity<?> registerUser(SignUpUser signUpUser);
}
