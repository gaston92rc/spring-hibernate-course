package com.luv2code.springdemo;

import com.luv2code.springdemo.coaches.BoxCoach;
import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.services.FortuneService;
import com.luv2code.springdemo.services.SingleFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoxConfig {

    @Bean
    public FortuneService singleFortuneService(){
        return new SingleFortuneService();
    }

    @Bean
    public Coach boxCoach(){
        return new BoxCoach(singleFortuneService());
    }
}
