package com.practice.checking.repository;

import com.practice.checking.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : yongjukim
 * @version : 1.0.0
 * @package : checking
 * @name : MemberRepository
 * @date : 9/6/24
 * @modifyed : $
 **/
public interface MemberRepository extends JpaRepository<Member, Long>, MemberCustomRepository {
}
