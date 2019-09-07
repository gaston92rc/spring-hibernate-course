package com.luv2code.springdemo.coaches;

import com.luv2code.springdemo.services.FortuneService;

public class BoxCoach implements Coach {

    private FortuneService fortuneService;

    public BoxCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practica un gancho";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
