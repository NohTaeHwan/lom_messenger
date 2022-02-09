package com.last1mile.study.lom_messenger.controller;


import com.last1mile.study.lom_messenger.model.ChatMessage;
import com.last1mile.study.lom_messenger.model.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Date;

@Component
@AllArgsConstructor
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    private final SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected : " + username);

            // FIXME DB생성되면 service layer 연결
            ChatMessage chatMessage = ChatMessage.builder()
                    .chatroomId((long) (Math.random()*10000)+1)
                    .userId((long) (Math.random()*10000)+1)
                    .time(new Date())
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            //chatMessage.setType(MessageType.LEAVE);
            //chatMessage.setSender(username);

            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}
