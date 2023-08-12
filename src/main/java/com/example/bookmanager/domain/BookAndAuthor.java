package com.example.bookmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class BookAndAuthor extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Author author;

}
