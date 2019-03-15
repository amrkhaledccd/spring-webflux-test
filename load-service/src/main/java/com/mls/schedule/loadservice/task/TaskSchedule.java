package com.mls.schedule.loadservice.task;

import com.mls.schedule.loadservice.client.BookingServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskSchedule {

    @Autowired
    private BookingServiceClient client;

    @Scheduled(fixedRate = 10)
    public void task() {
        client.book();

        log.info("called!");
    }

    @Scheduled(fixedRate = 10)
    public void task2Reactive() {
        client.bookReactive();
        log.info("called2! Reactive");
    }

}
