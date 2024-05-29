package com.ecom.online.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String userName;

    private  String email;

    private String password;

    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private AddressEntity address;


}
