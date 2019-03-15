package com.mls.bookingservice.model;

import lombok.Data;

@Data
public class BookingRequestBody {

    private String room;
    private int days;

    public String toString() {
        return String.format("[%s, %d]", room, days);
    }
}
