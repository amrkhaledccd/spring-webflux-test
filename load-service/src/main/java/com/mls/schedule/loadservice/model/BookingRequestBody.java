package com.mls.schedule.loadservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestBody {

    private String room;
    private int days;

    public String toString() {
        return String.format("[%s, %d]", room, days);
    }
}
