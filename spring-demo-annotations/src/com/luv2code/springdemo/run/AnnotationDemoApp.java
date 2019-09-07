package com.luv2code.springdemo.run;

import com.luv2code.springdemo.coaches.MmaCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MmaCoach coach = context.getBean("mmaCoach", MmaCoach.class);

        System.out.println(coach.getSportName());

        System.out.println(coach.getSportType());

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        context.close();
    }
}
