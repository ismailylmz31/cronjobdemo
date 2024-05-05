package com.y1forcode.cronjobdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SenderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/send")
    public ResponseEntity<String> sendRequest() {
        String receiverUrl = "http://localhost:8080/receive"; // Receiver uygulamasının URL'si
        ResponseEntity<String> response = restTemplate.getForEntity(receiverUrl, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
