package com.mls.schedule.loadservice.client;

import com.mls.schedule.loadservice.model.BookingRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class BookingServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String BOOKING_SERVICE_URL = "http://localhost:7000/";
    private final String REACTIVE_BOOKING_SERVICE_URL = "http://localhost:8000/";

    @Async("threadPoolTaskExecutor")
    public Boolean book() {
        String[] roomTypes = new String[]{"Single", "Double", "Triple"};

        BookingRequestBody booking =
                new BookingRequestBody(roomTypes[randomNumber(0, 3)], randomNumber(1, 31));

        restTemplate.postForEntity(BOOKING_SERVICE_URL +"booking", booking, BookingRequestBody.class);

        return true;
    }

    @Async("threadPoolTaskExecutor")
    public Boolean bookReactive() {
        String[] roomTypes = new String[]{"Single", "Double", "Triple"};

        BookingRequestBody booking =
                new BookingRequestBody(roomTypes[randomNumber(0, 3)], randomNumber(1, 31));

        restTemplate.postForEntity(REACTIVE_BOOKING_SERVICE_URL +"booking", booking, BookingRequestBody.class);

        return true;
    }

    private int randomNumber(int min, int max) {
        return new Random()
                .ints(1,  min,  max)
                .findAny()
                .getAsInt();
    }
}
