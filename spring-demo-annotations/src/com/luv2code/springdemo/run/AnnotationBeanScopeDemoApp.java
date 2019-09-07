package com.luv2code.springdemo.run;

import com.luv2code.springdemo.coaches.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("tennisCoach",Coach.class);
        Coach otherCoach = context.getBean("tennisCoach",Coach.class);

        if(coach == otherCoach){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }


        context.close();

    }
}
