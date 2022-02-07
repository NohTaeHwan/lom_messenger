package com.last1mile.study.lom_messenger.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * 유저의 채팅참여를 알수있는 객체
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class ChatroomInfo {

    private Long id;

    //User 객체 id
    private Long userId;

    //chatroom 객체 id
    private Long chatroomId;

    // FIXME Date 쓰면 안됨
    private Date createdAt;
    private Date updatedAt;

}
