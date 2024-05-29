package com.ecom.online.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private String price;

    private String description;

    private boolean isProductavailable;


}
