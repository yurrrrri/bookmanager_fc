package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

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

        bookRepository.findBookNameAndCategory().forEach(b -> {
            System.out.println(b.getName() + " : " + b.getCategory());
        });
    }

    @Test
    void pageableTest() {
        bookRepository.findBookNameAndCategory(PageRequest.of(0, 1))
                .forEach(bc -> System.out.println(bc.getName() + ", " + bc.getCategory()));

        bookRepository.findBookNameAndCategory(PageRequest.of(1, 1))
                .forEach(bc -> System.out.println(bc.getName() + ", " + bc.getCategory()));
    }

    @Test
    void nativeQueryTest() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println("affected rows : " + bookRepository.updateCategories());
        bookRepository.findAllCustom().forEach(System.out::println);
        System.out.println(bookRepository.showTables());
    }
}