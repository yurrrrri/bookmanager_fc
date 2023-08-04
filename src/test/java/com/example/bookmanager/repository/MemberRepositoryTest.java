package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void crud() {
        Member member1 = new Member("jack", "jack@example.com");
        Member member2 = new Member("sophie", "sophie@example.com");

        memberRepository.saveAll(Lists.newArrayList(member1, member2));

        List<Member> saveMembers = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        saveMembers.forEach(System.out::println);
    }

}