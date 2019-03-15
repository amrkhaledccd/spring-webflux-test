package com.mls.bookingservicereactive.handler;

import com.mls.bookingservicereactive.entity.Booking;
import com.mls.bookingservicereactive.model.BookingRequestBody;
import com.mls.bookingservicereactive.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@Slf4j
public class BookingHandler {

    @Autowired
    private BookingService bookingService;

    public Mono<ServerResponse> makeBooking(ServerRequest serverRequest) {

        Mono<BookingRequestBody> bookingBody = serverRequest.bodyToMono(BookingRequestBody.class);

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookingBody
                        .map(body -> {log.info("Booking {}", body); return body;})
                        .flatMap(body -> bookingService.book(body.getRoom(), body.getDays())) , Booking.class);
    }

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        log.info("Retrieving all bookings");
        return ok()
                .body(BodyInserters.fromPublisher(bookingService.all(), Booking.class));
    }
}
