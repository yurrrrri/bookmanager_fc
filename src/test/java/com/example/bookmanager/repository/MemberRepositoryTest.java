package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        Member member1 = new Member("jack", "jack@example.com");
        Member member2 = new Member("sophie", "sophie@example.com");

        memberRepository.saveAll(Lists.newArrayList(member1, member2));
    }

    @Test
    void crud() {
        List<Member> saveMembers = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        saveMembers.forEach(System.out::println);

        Member getMember = memberRepository.findById(1L).orElse(null);
        System.out.println(getMember);
    }

    @Test
    void crudMatcher() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<Member> example = Example
                .of(new Member("hi", "example.com"), matcher);

        memberRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void select() {
        System.out.println(memberRepository.findByName("jack"));
    }
}