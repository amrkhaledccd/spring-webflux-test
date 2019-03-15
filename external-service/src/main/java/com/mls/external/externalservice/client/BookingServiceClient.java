package com.mls.external.externalservice.client;

import com.mls.external.externalservice.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingServiceClient {

    private final String BOOKING_SERVICE_URL = "http://localhost:7000/booking";

    @Autowired
    private RestTemplate restTemplate;

    public List<Booking> allBookings() {

        ResponseEntity<List<Booking>> response = restTemplate.exchange(
                BOOKING_SERVICE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Booking>>(){});

        return response.getBody();
    }
}
