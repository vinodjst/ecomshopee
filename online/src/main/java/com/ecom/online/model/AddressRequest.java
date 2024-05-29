package com.ecom.online.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressRequest {

    private String street;

    private String area;

    private  String pinCode;

    private String dist;

    private String state;

    private  String country;

}
