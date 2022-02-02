package com.last1mile.study.lom_messenger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // used to enable our WebSocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 클라이언트가 웹 소켓 서버에 연결하는데 사용할 웹 소켓 엔드포인트를 등록
    // withSockJS()를 사용하여 웹 소켓을 지원하지 않는 브라우저에 폴백 옵션을 활성화하는데 사용
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
        registry.addEndpoint("/ws").withSockJS();
    }

    // 한 클라이언트에서 다른 클라이언트로 메시지를 라우팅 하는데 사용될 메세지 브로커 구성
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
        registry.setApplicationDestinationPrefixes("/app");//"/app" 시작되는 메시지가 message-handling methods으로 라우팅 되어야 한다는 것을 명시합니다.
        registry.enableSimpleBroker("/topic");//"/topic" 시작되는 메시지가 메시지 브로커로 라우팅 되도록 정의합니다(연결된 모든 클라에게 브로드캐스트)
    }
}
