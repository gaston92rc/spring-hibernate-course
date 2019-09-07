package com.luv2code.springdemo.run;

import com.luv2code.springdemo.SportConfig;
import com.luv2code.springdemo.coaches.SwimCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        System.out.println("Email: "+coach.getEmail());

        System.out.println("Team: "+coach.getTeam());

        context.close();
    }
}
