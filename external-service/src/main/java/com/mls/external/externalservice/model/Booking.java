package com.mls.external.externalservice.model;

import lombok.Data;


@Data
public class Booking {

    private String id;
    private String room;
    private int days;

    @Override
    public String toString() {
        return String.format("[%s, %s, %d]", id, room, days);
    }
}