package com.example.AppEcommerce.Service;



import com.example.AppEcommerce.Dto.JwtResonse;
import com.example.AppEcommerce.Dto.LoginRequest;
import com.example.AppEcommerce.Dto.MessageResponse;
import com.example.AppEcommerce.Dto.SignUpAdmin;
import com.example.AppEcommerce.Enum.Role;
import com.example.AppEcommerce.Impl.AuthServiceImp;
import com.example.AppEcommerce.Model.User;
import com.example.AppEcommerce.Repository.UserRepository;
import com.example.AppEcommerce.Security.UserDetailsImpl;
import com.example.AppEcommerce.Security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AuthService implements AuthServiceImp {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public ResponseEntity<?> registerAdmin(SignUpAdmin signUpAdmin){
        if (userRepository.existsByEmail(signUpAdmin.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error:email is already taken!"));
        }

        User user =new User( signUpAdmin.getEmail(),encoder.encode(signUpAdmin.getPassword()), Role.ADMIN);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Admin registered successfully!"));

    }

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        User user = userRepository.findById(userDetails.getId()).get();
        return ResponseEntity.ok(new JwtResonse(jwt,
                user,
                roles));

    }

}
