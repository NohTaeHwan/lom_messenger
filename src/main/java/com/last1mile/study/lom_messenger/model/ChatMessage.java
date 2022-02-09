package com.last1mile.study.lom_messenger.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * 채팅 메세지 객체
 */
@Builder(toBuilder = true)
@Getter
@ToString
public class ChatMessage {

    //private Long id;

    // Chatroom 객체 id
    private Long chatroomId;

    // User 객체 id
    private Long userId;

    // FIXME Date 쓰면 안됨
    // 메세지 보낸 시각
    private Date time;



    // 메세지 내용
    private String text;

    // 메세지 타읿 (CHAT,JOIN,LEAVE)
    private MessageType type;

    //임시 필드
    private String sender;
    // FIXME Date 쓰면 안됨
    //private Date createdAt;
    //private Date updatedAt;

}
