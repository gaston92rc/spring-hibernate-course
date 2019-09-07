package com.luv2code.springdemo.run;

import com.luv2code.springdemo.SportConfig;
import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.coaches.TennisCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        Coach coach = context.getBean("tennisCoach", TennisCoach.class);

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        context.close();
    }
}
