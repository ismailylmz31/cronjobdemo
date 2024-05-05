package com.y1forcode.cronjobdemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class YoutubeRedirectScheduler {

    private final List<String> youtubeLinks = Arrays.asList(
            "https://www.youtube.com/watch?v=dQw4w9WgXcQ", // Rickroll :)
            "https://www.youtube.com/watch?v=VgSMxY6asoE", // Cats
            "https://www.youtube.com/watch?v=OK3GJ0WIQ8s"  // Music
            // Diğer YouTube linklerini buraya ekleyebilirsiniz
    );

    private final RestTemplate restTemplate;

    @Autowired
    public YoutubeRedirectScheduler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRate = 180000) // Her 3 dakikada bir çalışır
    public void redirectToYoutube() {
        String randomLink = getRandomYoutubeLink();
        ResponseEntity<String> response = restTemplate.getForEntity(randomLink, String.class);
        HttpStatus statusCode = (HttpStatus) response.getStatusCode();
        System.out.println("Redirected to: " + randomLink + ", Status: " + statusCode);
    }

    private String getRandomYoutubeLink() {
        Random random = new Random();
        int randomIndex = random.nextInt(youtubeLinks.size());
        return youtubeLinks.get(randomIndex);
    }
}
