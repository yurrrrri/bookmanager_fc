package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("book1");
        book.setAuthor("yuri");

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }

    @Test
    void queryTest() {
        bookRepository.findAll().forEach(System.out::println);

        System.out.println("findByNameRecently : " +
                bookRepository.findByNameRecently("JPA 초격차 패키지",
                        LocalDateTime.now().minusDays(1L),
                        LocalDateTime.now().minusDays(1L))
        );
    }
}