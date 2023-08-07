package com.example.bookmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

}
