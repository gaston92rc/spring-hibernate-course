package com.luv2code.springdemo.services;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileReader;

@Component
public class FileFortuneService implements FortuneService{
    private String fileName = "src/fortune-data.txt";
    private List<String> theFortunes;
    private Random random = new Random();

    public FileFortuneService() {
//        System.out.println(">>FileFortuneService: inside default constructor");
    }
    @PostConstruct
    private void loadTheFortuneFile(){
        File theFile = new File(fileName);
//        System.out.println("Leyendo el archivo: "+fileName);
//        System.out.println("El archivo existe: "+theFile.exists());
//        System.out.println("---------------------------------------");
        theFortunes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
            String tempLine;

            while ((tempLine = br.readLine())!= null){
                theFortunes.add(tempLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int index = random.nextInt(theFortunes.size());
        return "Fortune: "+theFortunes.get(index);
    }
}
