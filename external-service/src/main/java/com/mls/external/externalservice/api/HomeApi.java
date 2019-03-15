package com.mls.external.externalservice.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeApi {

    @GetMapping("/delay")
    @ResponseStatus(HttpStatus.OK)
    public String doSomething() {
        log.info("Delaying ...");

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello from external";
    }
}
