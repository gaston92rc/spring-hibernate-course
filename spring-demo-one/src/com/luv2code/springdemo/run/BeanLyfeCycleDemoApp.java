package com.luv2code.springdemo.run;

import com.luv2code.springdemo.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLyfeCycleDemoApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        Coach coach = context.getBean("myCoach", Coach.class);
        Coach otroCoach = context.getBean("myCoach",Coach.class);

        if(coach == otroCoach){
            System.out.println("SON IGUELES");
        }else{
            System.out.println("NO SON IGUELS");
        }

        System.out.println(coach.getDailyWorkout());



        context.close();

    }
}
