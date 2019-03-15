package com.mls.bookingservicereactive.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@RequiredArgsConstructor
@Document
public class Booking {

    @Id
    private String id;

    @NonNull
    private String room;

    @NonNull
    private int days;

    @Override
    public String toString() {
        return String.format("[%s, %s, %d]", id, room, days);
    }
}

