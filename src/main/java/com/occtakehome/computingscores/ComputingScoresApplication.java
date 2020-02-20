package com.occtakehome.computingscores;

import com.occtakehome.computingscores.controller.ScoreController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
public class ComputingScoresApplication {

    private static final Logger logger = LoggerFactory.getLogger(ComputingScoresApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ComputingScoresApplication.class, args);
        ScoreController scoreController = applicationContext.getBean(ScoreController.class);
        logger.info("Application Started");
        System.out.println("Please enter the file name: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //since a single line of input will be given
        StringBuilder listOfNames = new StringBuilder();
        if (fileScanner != null) {
            while (fileScanner.hasNextLine()) {
                listOfNames.append(fileScanner.nextLine());
            }
        }

        logger.info("The total score is " + scoreController.computeScores(listOfNames.toString()));
        applicationContext.close();
    }
}
