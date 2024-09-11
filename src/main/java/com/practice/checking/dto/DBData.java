package com.practice.checking.dto;

import com.practice.checking.entity.Member;
import lombok.*;

/**
 * @author : yongjukim
 * @version : 1.0.0
 * @package : checking
 * @name : DBData
 * @date : 9/5/24
 * @modifyed : $
 **/

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DBData {

    private Long id;
    private String name;
    private String phoneNumber;
    private String region;

    public void getMember(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.phoneNumber = member.getPhoneNumber();
        this.region = member.getRegion();
    }

    public void setMember(String name, String phoneNumber, String region) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.region = region;
    }

}
