package com.luv2code.springdemo.run;

import com.luv2code.springdemo.Coach;
import com.luv2code.springdemo.coaches.TrackCoach;

public class MyApp {

    public static void main(String[] args) {
        Coach theCoach = new TrackCoach();
        System.out.println(theCoach.getDailyWorkout());
    }
}
