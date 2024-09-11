package com.practice.checking.repository;

import com.practice.checking.dto.DBData;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.practice.checking.entity.QMember.member;


/**
 * @author : yongjukim
 * @version : 1.0.0
 * @package : checking
 * @name : MainRepositoryImpl
 * @date : 9/5/24
 * @modifyed : $
 **/

@RequiredArgsConstructor
@Repository
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<DBData> getDBData() {
        List<DBData> dbData = jpaQueryFactory
                .select(Projections.constructor(DBData.class,
                        member.id,
                        member.name,
                        member.phoneNumber,
                        member.region))
                .from(member)
                .fetch();

        return  dbData;
    }
}
