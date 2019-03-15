package com.mls.bookingservicereactive.router;

import com.mls.bookingservicereactive.handler.BookingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;



@Configuration
public class BookingRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(BookingHandler bookingHandler) {
        return route(POST("/booking"), bookingHandler::makeBooking)
                .andRoute(GET("/booking"), bookingHandler::findAll);
//                .andRoute(GET("/stream").and());
    }
}
