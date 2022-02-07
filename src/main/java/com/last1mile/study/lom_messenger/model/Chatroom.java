package com.last1mile.study.lom_messenger.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * 채팅방 객체
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class Chatroom {

    private Long id;

    // 채팅방 이름
    private String roomName;

    // FIXME Date 쓰면 안됨
    private Date createdAt;
    private Date updatedAt;
}
