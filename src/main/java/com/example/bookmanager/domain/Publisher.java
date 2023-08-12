package com.example.bookmanager.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Publisher extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "publisher_id")
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
    }

}
