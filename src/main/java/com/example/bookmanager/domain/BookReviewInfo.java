package com.example.bookmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class BookReviewInfo extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(optional = false)
    private Book book;

    private float averageReviewScore;

    private int reviewCount;

}
