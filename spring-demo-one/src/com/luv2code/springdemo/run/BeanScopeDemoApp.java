package com.luv2code.springdemo.run;

import com.luv2code.springdemo.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach coach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        boolean result = coach == alphaCoach;
        if(result){
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales ");
        }


        context.close();

    }
}
