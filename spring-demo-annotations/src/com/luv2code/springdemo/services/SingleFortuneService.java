package com.luv2code.springdemo.services;

public class SingleFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "La sabiduria no esta en el decir, si no en el hacer";
    }
}
