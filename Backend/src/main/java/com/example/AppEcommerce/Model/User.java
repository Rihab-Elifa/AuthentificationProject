package com.example.AppEcommerce.Model;


import com.example.AppEcommerce.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.Email;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;



@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
     private String id;
    @Email
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private long phone;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String email, String password, Role role ) {
        this.email=email;
        this.password=password;
        this.role=role;
    }

    public User(String email, String password, Role role, String firstName, String lastName, long phone) {
        this.email=email;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.role=role;
        this.phone=phone;

    }


    public boolean isPresent() {
        return true;
    }

}
