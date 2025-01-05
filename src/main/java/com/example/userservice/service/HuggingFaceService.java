package com.example.userservice.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HuggingFaceService {
    private static final String HUGGING_FACE_API_URL = "https://api-inference.huggingface.co/models/tiiuae/falcon-7b-instruct";

    public String ask(String request) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(System.getenv("HUGGING_FACE_API_KEY"));

        String requestBody = """
                {
                    "inputs": "%s",
                    "parameters": {"max_length": 200}
                }
                """.formatted(request);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(HUGGING_FACE_API_URL, HttpMethod.POST, entity, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to get response: " + response.getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: Unable to process your request at the moment.";
        }
    }

}
