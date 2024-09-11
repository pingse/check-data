package com.practice.checking.repository;

import com.practice.checking.dto.DBData;

import java.util.List;

/**
 * @author : yongjukim
 * @version : 1.0.0
 * @package : checking
 * @name : MainRepository
 * @date : 9/5/24
 * @modifyed : $
 **/
public interface MemberCustomRepository {
    List<DBData> getDBData();

}
