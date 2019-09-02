package com.cactus.reservationclient.controller;

import com.cactus.reservationclient.domin.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "reservation-service")
public interface ReservationRead {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    Resources<User> read();
}
