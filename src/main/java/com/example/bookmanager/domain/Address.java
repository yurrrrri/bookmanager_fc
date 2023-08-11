package com.example.bookmanager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;

    private String district;

    @Column(name = "address_detail")
    private String detail;

    private String zipCode;

}
