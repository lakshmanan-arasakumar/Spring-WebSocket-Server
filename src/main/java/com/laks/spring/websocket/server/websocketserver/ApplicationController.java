package com.laks.spring.websocket.server.websocketserver;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ApplicationController {

    @MessageMapping("/chat/{topic}")
    @SendTo("/topic/messages")
    public OutgoingMessage send(@DestinationVariable String topic, IncomingMessage message){

        return new OutgoingMessage(message.getFrom(), message.getText(), topic);
    }
}
