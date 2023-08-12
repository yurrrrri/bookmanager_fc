package com.example.bookmanager.domain;

import com.example.bookmanager.domain.converter.BookStatusConverter;
import com.example.bookmanager.repository.dto.BookStatus;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Publisher publisher;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    private boolean deleted;

    @Convert(converter = BookStatusConverter.class)
    private BookStatus status;

    public void addBookAndAuthors(BookAndAuthor... bookAndAuthors) {
        Collections.addAll(this.bookAndAuthors, bookAndAuthors);
    }

}
