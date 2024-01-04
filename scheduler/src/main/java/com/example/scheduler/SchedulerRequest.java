package com.example.scheduler;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;

import reactor.core.publisher.Mono;

@Component
public class SchedulerRequest {

    private final WebClient webClient;

    @Autowired
    public SchedulerRequest(WebClient webClient) {
        this.webClient = webClient;
    }

    @Scheduled(fixedDelay = 10000)
    public void schedulerRequest() throws JsonProcessingException {
        String[] status = { "Poor", "Good", "Excellent" };
        Random random = new Random();

        Locomotive locomotive = Locomotive.builder()
                .locoCode(UUID.randomUUID().toString().substring(0, 13))
                .locoName("Loco" + UUID.randomUUID().toString().substring(0, 4))
                .locoDimension("10 x 10")
                .status(status[random.nextInt(status.length)])
                .time(LocalDateTime.now().toString())
                .build();

        webClient.post()
                .uri("/forward")
                .body(Mono.just(locomotive), Locomotive.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
