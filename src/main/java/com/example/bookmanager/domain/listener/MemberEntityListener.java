package com.example.bookmanager.domain.listener;

import com.example.bookmanager.domain.Member;
import com.example.bookmanager.domain.MemberHistory;
import com.example.bookmanager.repository.MemberHistoryRepository;
import com.example.bookmanager.support.BeanUtils;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;

public class MemberEntityListener {

    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o) {
        MemberHistoryRepository memberHistoryRepository = BeanUtils
                .getBean(MemberHistoryRepository.class);

        Member member = (Member) o;

        MemberHistory memberHistory = new MemberHistory();
        memberHistory.setName(member.getName());
        memberHistory.setEmail(member.getEmail());
        memberHistory.setMember(member);
        memberHistory.setHomeAddress(member.getHomeAddress());
        memberHistory.setCompanyAddress(member.getCompanyAddress());

        memberHistoryRepository.save(memberHistory);
    }

}
