package com.luv2code.springdemo.coaches;

import com.luv2code.springdemo.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MmaCoach implements Coach {

    @Value("${foo.sportname}")
    private String SportName;
    @Value("${foo.sporttype}")
    private String SportType;
    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    public MmaCoach() {
    }

    public String getSportName() {
        return SportName;
    }

    public String getSportType() {
        return SportType;
    }

    @Override
    public String getDailyWorkout() {
        return "Practica tu UpperCut";
    }

    @PostConstruct
    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
