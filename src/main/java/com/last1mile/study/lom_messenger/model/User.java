package com.last1mile.study.lom_messenger.model;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * User 객체
 */
// FIXME @Setter 쓰면 안됨
@Getter
@Builder(toBuilder = true)
@ToString
public class User {

    private Long id;

    // 유저 로그인 아이디
    private String userId;

    // 유저 이름
    private String username;

    // 유저 비밀번호
    private String password;

    // 유저 별명
    private String nickname;

    // 유저 상태(0:오프라인,1:접속중,2:자리비움)
    private Integer status;

    // 유저 프로필 이미지
    private String image;

    // 유저 핸드폰 번호
    private String phoneNumber;

    // FIXME Date 쓰면 안됨
    private Date createdAt;
    private Date updatedAt;


}
