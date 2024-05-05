package com.y1forcode.cronjobdemo.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiverController {

    private boolean isAppRunning = true;

    @GetMapping("/receive")
    public String receiveRequest() {
        if (!isAppRunning) {
            return "Uygulama ayakta değil, bekliyorum...";
        }
        return "Request received successfully";
    }

    @Scheduled(fixedRate = 1000) // Her 10 saniyede bir kontrol et
    public void checkAppStatus() {
        if (!isAppRunning) {
            System.out.println("Uygulama ayakta değil!");
        }
    }
}
