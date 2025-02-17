package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    /*
     * whenever a client sends a message to the /app/sendMessage endpoint it is handled here
     * then @sendTo annotation tells spring to broadcast the return value of sendMessage() to all the clients
     * subscribed to the "/topic/messages" topic
     */
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    /*
    * who ever is visiting root("chat") URL we will return the thymeleaf template as shown below
    */
    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }
}
