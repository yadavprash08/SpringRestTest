package com.prashant.java.ws.rest.controller;

import com.prashant.java.ws.rest.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by yprasha on 6/3/16.
 */
@RestController
public class Authentication {

    @RequestMapping("/User/Register")
    public User register(@RequestParam(value = "name") String userName) {
        Objects.requireNonNull(userName);
        UUID userId = UUID.randomUUID();
        return User.builder().userId(userId.toString()).userName(userName).build();
    }
}
