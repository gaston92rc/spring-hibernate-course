package com.luv2code.springdemo.services;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private Random random = new Random();

    private String[] fortune = {"No dejes que los demás se interpongan en tu camino.",
    "Mañana será un mejor día.",
    "Ten gratitud, aunque pienses que tu vida no es perfecta.",
    "Un viaje se aproxima."
    ,"El ocio es una tontería.",
    "Evita a las personas negativas para mantener una actitud positiva.",
    "La felicidad puede encontrarse frente a tu nariz y no la notas."};

    @Override
    public String getFortune() {
        int index = random.nextInt(fortune.length);
        return fortune[index];
    }
}
