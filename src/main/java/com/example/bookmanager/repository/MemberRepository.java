package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);

    Page<Member> findByName(String name, Pageable pageable);

    @Query(value = "select * from member limit 1", nativeQuery = true)
    Map<String, Object> findRawRecord();

    @Query(value = "select * from member", nativeQuery = true)
    List<Map<String, Object>> findAllRawRecord();
}
