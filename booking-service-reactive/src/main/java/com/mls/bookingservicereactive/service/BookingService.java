package com.mls.bookingservicereactive.service;

import com.mls.bookingservicereactive.client.ExternalServiceClient;
import com.mls.bookingservicereactive.entity.Booking;
import com.mls.bookingservicereactive.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ExternalServiceClient client;

    public Mono<Booking> book(String room, int days) {
        Booking booking = new Booking(room, days);

        return client
                .delay()
                .map(res -> {log.info("External response: {}", res); return res;})
                .then(bookingRepository.save(booking));
    }

    public Flux<Booking> all() {
        return bookingRepository.findAll();
    }
}
