package com.y1forcode.cronjobdemo.controller;

import com.y1forcode.cronjobdemo.component.YoutubeRedirectScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YoutubeRedirectController {

    private final YoutubeRedirectScheduler scheduler;

    @Autowired
    public YoutubeRedirectController(YoutubeRedirectScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @GetMapping("/startRedirect")
    public ResponseEntity<String> startRedirect() {
        scheduler.redirectToYoutube();
        return ResponseEntity.ok("Redirect started successfully.");
    }
}
