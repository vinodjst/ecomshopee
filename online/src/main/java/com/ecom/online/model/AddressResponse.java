package com.ecom.online.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    private String street;

    private String area;

    private  String pinCode;

    private String dist;

    private String state;

    private  String country;
}
