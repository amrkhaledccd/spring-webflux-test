package com.mls.bookingservice.repository;

import com.mls.bookingservice.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
