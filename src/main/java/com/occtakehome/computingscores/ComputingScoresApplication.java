package com.occtakehome.computingscores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComputingScoresApplication {

    public static void main(String[] args) {
        System.setProperty("file.name",args[0]);
        SpringApplication.run(ComputingScoresApplication.class, args);
    }
}
