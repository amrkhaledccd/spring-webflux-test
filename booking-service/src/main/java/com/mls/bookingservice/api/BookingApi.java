package com.mls.bookingservice.api;


import com.mls.bookingservice.entity.Booking;
import com.mls.bookingservice.model.BookingRequestBody;
import com.mls.bookingservice.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookingApi {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/booking")
    @ResponseStatus(HttpStatus.CREATED)
    public void makeBooking(@RequestBody BookingRequestBody booking) {
        log.info("Booking {}", booking);
        bookingService.book(booking.getRoom(), booking.getDays());
    }

    @GetMapping("/booking")
    @ResponseStatus(HttpStatus.OK)
    public List<Booking> findAll() {
        log.info("Retrieving all bookings");
        return bookingService.all();
    }
}
