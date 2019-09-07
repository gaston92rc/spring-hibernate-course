package com.luv2code.springdemo;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.coaches.SwimCoach;
import com.luv2code.springdemo.services.FortuneService;
import com.luv2code.springdemo.services.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }

}
