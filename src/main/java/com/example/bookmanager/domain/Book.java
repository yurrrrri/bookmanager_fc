package com.example.bookmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Where(clause = "deleted = false")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String category;

    private String author;

    @OneToOne(mappedBy = "book")
    private BookReviewInfo bookReviewInfo;

    private boolean deleted;

}
