package com.ecom.online.model;

import com.ecom.online.entity.AddressEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private  String userName;

    private  String email;

    private String password;

    private AddressRequest address;



}
