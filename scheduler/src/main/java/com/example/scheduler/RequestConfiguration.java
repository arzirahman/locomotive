package com.example.scheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RequestConfiguration {
    @Bean
    WebClient webClient() {
        return WebClient.builder().baseUrl("http://localhost:3050/").build();
    }
}
