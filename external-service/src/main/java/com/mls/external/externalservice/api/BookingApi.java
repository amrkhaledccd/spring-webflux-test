package com.mls.external.externalservice.api;


import com.mls.external.externalservice.client.BookingServiceClient;
import com.mls.external.externalservice.client.ReactiveBookingServiceClient;
import com.mls.external.externalservice.model.Booking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class BookingApi {

    @Autowired
    private BookingServiceClient bookingServiceClient;

    @Autowired
    private ReactiveBookingServiceClient reactiveBookingServiceClient;


    @GetMapping("/booking")
    @ResponseStatus(HttpStatus.OK)
    public String getAllBoooking() {
        List<Booking> bookings =
                bookingServiceClient.allBookings();

        bookings.forEach(System.out::println);

        log.info("Size: {}", bookings.size());
        return "Done";
    }

    @GetMapping("/booking/reactive")
    @ResponseStatus(HttpStatus.OK)
    public String getAllBoookingReactive() {
        reactiveBookingServiceClient
                .allBookings()
                .subscribe(System.out::println);

        return "Done";
    }
}
