package com.example.AppEcommerce.Model;

import com.example.AppEcommerce.Enum.Activity;
import com.example.AppEcommerce.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class vendor extends User{
    private String name ;
    @Enumerated(EnumType.STRING)
    private Activity activity;
    private String address;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private File image;


    public vendor(String email, String password, Role role, Activity activity, String address, File image) {
        super(email,password,role);
        this.activity=activity;
        this.address=address;
        this.image=image;
    }
}
