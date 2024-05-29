package com.ecom.online.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotNull(message = "username cannot be null")
    @NotBlank(message = "username cannot be blank")
    private String username;

    @Email(message = "Invalid email address")
    @NotBlank(message = "email cannot be blank")
    @NotNull(message = "email cannot be null")
    private String email;

    @NotBlank(message = "password cannot be blank")
    @NotNull(message = "password cannot be null")
    private String password;

    private  AddressRequest address;



}
