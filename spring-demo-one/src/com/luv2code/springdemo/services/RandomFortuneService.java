package com.luv2code.springdemo.services;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private String[] fortunes = {"Hoy te llegará esa noticia que tanto esperabas",
            "Al abrir la puerta te llevaras una increible sopresa",
            "Esa persona que tanto queres, te dira lo que siente",
            "Vas a recibir una propuesta laboral",
            "Es probable que seas rico en poco tiempo"};


    @Override
    public String getFortune() {
        Random random = new Random();
        int index = random.nextInt(fortunes.length);
        return fortunes[index];
    }
}
