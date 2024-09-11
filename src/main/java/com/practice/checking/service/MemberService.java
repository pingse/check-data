package com.practice.checking.service;

import com.practice.checking.dto.DBData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : yongjukim
 * @version : 1.0.0
 * @package : checking
 * @name : MemberService
 * @date : 9/6/24
 * @modifyed : $
 **/

public interface MemberService {

    @Transactional
    void dbWrite(DBData data);

    List<DBData> getDbData();
}
