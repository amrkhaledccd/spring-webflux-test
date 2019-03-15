package com.mls.bookingservicereactive.client;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ExternalServiceClient {

    private final String EXTERNAL_SERVICE_URL = "http://localhost:6000";

    public Mono<String> delay() {

        return WebClient
                .create(EXTERNAL_SERVICE_URL)
                .get()
                .uri("/delay")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));
    }
}
