package com.mls.external.externalservice.client;

import com.mls.external.externalservice.model.Booking;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ReactiveBookingServiceClient {

    private final String REACTIVE_BOOKING_SERVICE_URL = "http://localhost:8000";

    public Flux<Booking> allBookings() {

        return WebClient
                .create(REACTIVE_BOOKING_SERVICE_URL)
                .get()
                .uri("/booking")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMapMany(response -> response.bodyToFlux(Booking.class));
    }
}
