package com.mls.bookingservicereactive.repository;

import com.mls.bookingservicereactive.entity.Booking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookingRepository extends ReactiveMongoRepository<Booking, String> {
}
