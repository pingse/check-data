package com.practice.checking.service;

import com.practice.checking.dto.DBData;
import com.practice.checking.entity.Member;
import com.practice.checking.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : yongjukim
 * @version : 1.0.0
 * @package : checking
 * @name : MemberServiceImpl
 * @date : 9/6/24
 * @modifyed : $
 **/

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void dbWrite(DBData data) {
        Member member = Member
                .builder()
                .name(data.getName())
                .phoneNumber(data.getPhoneNumber())
                .region(data.getRegion())
                .build();

        memberRepository.save(member);
    }

    @Override
    public List<DBData> getDbData() {

        List<DBData> dbDataList = memberRepository.getDBData();

        return dbDataList;
    }
}
