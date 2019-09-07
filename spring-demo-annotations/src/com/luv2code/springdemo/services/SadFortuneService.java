package com.luv2code.springdemo.services;

import com.luv2code.springdemo.services.FortuneService;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is a sad day :(";
    }
}
