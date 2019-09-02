package com.cactus.reservationclient.controller;

import com.cactus.reservationclient.domin.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReservationController {

    private final ReservationRead reservationRead;


    @Autowired
    public ReservationController (ReservationRead reservationRead) {
        this.reservationRead = reservationRead;
    }

    public List<String> fallback() {
        return Arrays.asList("fallback1", "fallback2");
    }

    // feignClient 与 熔断机制
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "/users/names", method = RequestMethod.GET)
    public List<String> read() {
        Resources<User> read = this.reservationRead.read();
        Collection<User> content = read.getContent();
        return content
                .stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

}
