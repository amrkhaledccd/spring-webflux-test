package com.mls.bookingservice.service;

import com.mls.bookingservice.client.ExternalServiceClient;
import com.mls.bookingservice.entity.Booking;
import com.mls.bookingservice.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ExternalServiceClient client;

    public void book(String room, int days) {

        Booking booking = new Booking(room, days);
        String externalResponse = client.delay();

        log.info("External response: {}", externalResponse);
        bookingRepository.save(booking);
    }

    public List<Booking> all() {
        return bookingRepository.findAll();
    }
}
