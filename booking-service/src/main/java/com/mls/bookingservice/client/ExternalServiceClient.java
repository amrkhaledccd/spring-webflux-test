package com.mls.bookingservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalServiceClient {

    private final String EXTERNAL_SERVICE_URL = "http://localhost:6000/delay";

    @Autowired
    private RestTemplate restTemplate;

    public String delay() {
      return restTemplate.getForObject(EXTERNAL_SERVICE_URL, String.class);
    }
}
