package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();

    // JPQL
    @Query(value = "select b from Book b " +
            "where name = ?1 and createdAt >= ?2 and updatedAt >= ?3 and category is null")
    List<Book> findByNameRecently(String name, LocalDateTime createdAt, LocalDateTime updatedAt);

//    @Query(value = "select b from Book b " +
//            "where name = :name and createdAt >= :createdAt and updatedAt >= :updatedAt and category is null")
//    List<Book> findByNameRecently(
//            @Param("name") String name,
//            @Param("createdAt") LocalDateTime createdAt,
//            @Param("updatedAt") LocalDateTime updatedAt);

}
