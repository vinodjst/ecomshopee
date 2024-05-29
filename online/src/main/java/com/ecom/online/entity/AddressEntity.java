package com.ecom.online.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_name")
    private String street;

    @Column(name = "area_name")
    private String area;

    @Column(name = "pin_code")
    private  String pinCode;

    @Column(name = "district")
    private String dist;

    @Column(name = "state_name")
    private String state;

    @Column(name = "country_name")
    private  String country;



}
