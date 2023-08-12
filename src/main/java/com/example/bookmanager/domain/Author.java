package com.example.bookmanager.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Author extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String country;

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    public void addBookAndAuthors(BookAndAuthor... bookAndAuthors) {
        Collections.addAll(this.bookAndAuthors, bookAndAuthors);
    }

}
