package com.luv2code.springdemo.run;

import com.luv2code.springdemo.BoxConfig;
import com.luv2code.springdemo.coaches.BoxCoach;
import com.luv2code.springdemo.coaches.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoxConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BoxConfig.class);

        Coach coach = context.getBean("boxCoach",Coach.class);

        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyWorkout());

        context.close();
    }
}
