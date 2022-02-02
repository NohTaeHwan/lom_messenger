package com.last1mile.study.lom_messenger.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ChatMessage {

    private MessageType type;
    private String content;
    private String sender;

}
