package com.prashant.java.ws.rest.controller;

import com.prashant.java.ws.rest.model.Greeting;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yprasha on 6/2/16.
 */
@RestController
public class GreetingsController {

    private static final AtomicLong REQ_COUNTER = new AtomicLong(0l);

    @RequestMapping("/greet")
    public Greeting getGreeted(){
        String randomName = RandomStringUtils.randomAlphabetic(10);
        long requestId = REQ_COUNTER.incrementAndGet();
        return new Greeting(requestId, randomName);
    }
}
