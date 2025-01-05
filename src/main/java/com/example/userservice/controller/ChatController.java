package com.example.userservice.controller;

import com.example.userservice.service.ChatGptService;
import com.example.userservice.service.HuggingFaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatGptService chatGptService;
    private final HuggingFaceService huggingFaceService;

    public ChatController(ChatGptService chatGptService, HuggingFaceService huggingFaceService) {
        this.chatGptService = chatGptService;
        this.huggingFaceService = huggingFaceService;
    }

    @PostMapping("/openai")
    public ResponseEntity<String> askChatGpt(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        String response = chatGptService.askChatGpt(prompt);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/huggingFace")
    public String huggingFace(@RequestBody String request) {
        return huggingFaceService.ask(request);
    }
}
