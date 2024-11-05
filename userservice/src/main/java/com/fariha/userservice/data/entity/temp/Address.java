package com.fariha.userservice.data.entity.temp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String street;

    public String city;

    public String state;

    public String zip;

    public String country;

    public String phone;

    public String email;

    @OneToOne(mappedBy = "address")
    private Employee employee;
}
