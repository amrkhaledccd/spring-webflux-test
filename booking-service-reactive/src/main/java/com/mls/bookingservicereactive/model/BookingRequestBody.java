package com.mls.bookingservicereactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingRequestBody {
    private String room;
    private int days;

    public String toString() {
        return String.format("[%s, %d]", room, days);
    }
}
