package com.uway.chatapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

import com.uway.chatapp.model.ChatMessage;

@RestController
public class ChatApiController {
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		
		return chatMessage;
		
	}
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		
		return chatMessage;
	}

}
